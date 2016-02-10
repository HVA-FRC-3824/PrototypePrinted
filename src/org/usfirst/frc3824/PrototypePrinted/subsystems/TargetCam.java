// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3824.PrototypePrinted.subsystems;

import java.io.IOException;

import org.usfirst.frc3824.PrototypePrinted.Constants;
import org.usfirst.frc3824.PrototypePrinted.Robot;
import org.usfirst.frc3824.PrototypePrinted.RobotMap;
import org.usfirst.frc3824.PrototypePrinted.commands.*;
import org.usfirst.frc3824.PrototypePrinted.utilities.USBCamera;

import com.ni.vision.NIVision;
import com.sun.javafx.collections.MappingChange.Map;
import java.lang.reflect.Field;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Preferences;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class TargetCam extends Subsystem
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	private USBCamera m_targetCam;
	private NIVision.Image m_singleFrame;
	private boolean m_running;
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public TargetCam()
	{
		m_singleFrame = null;
		m_running = false;
		m_targetCam = null;
		
		for(int i=0; i<3 && m_targetCam == null; i++)
		{
			try
			{
				m_targetCam = new USBCamera("cam0");
			}
			catch(Exception e)
			{
				killImageProcessing();
	            Timer.delay(0.5);		// 0.5 second delay to give the process a chance to die
			}
		}
	}
		
	public void initDefaultCommand()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
	public void startStream()
	{
		boolean retry;
		
		if(m_singleFrame == null)
		{
			m_singleFrame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		}
		
		if(m_targetCam != null && !m_running)
		{
			retry = false;
			for(int i=0; i<3 && retry == true; i++)
			{
				try
				{
					m_targetCam.openCamera();
					retry = false;
				}
				catch(Exception e)
				{
					killImageProcessing();
		            Timer.delay(0.5);		// 0.5 second delay to give the process a chance to die
					retry = true;
				}
			}
			m_targetCam.startCapture();
			m_running = true;
		}
	}
	
	public void cameraDisable()
	{
		if(m_targetCam != null && !m_running)
		{
			m_targetCam.stopCapture();
			m_targetCam.closeCamera();
			m_running = false;
		}
	}
	public void updateDashboardImage()
	{
		// targetCam.updateSettings();
		// targetCam.startCapture();
		//for(int i=0; i<1000; i++);
		if(m_targetCam != null && m_running)
		{
			m_targetCam.getImage(m_singleFrame);
			CameraServer.getInstance().setImage(m_singleFrame);
		}
		// targetCam.stopCapture();
	}
	
	public void updateValuesOnDashboard()
	{
		SmartDashboard.putString("Current Exposure Value", m_targetCam.getExposure());
		SmartDashboard.putString("Current Exposure Mode", m_targetCam.getExposureMode());		
		SmartDashboard.putNumber("Current Brightness", m_targetCam.getBrightness());
		SmartDashboard.putNumber("Minimum Exposure", m_targetCam.getExposureMin());
		SmartDashboard.putNumber("Maximum Exposure", m_targetCam.getExposureMax());
	}
	
	public void setExposure(int exposure)
	{
		if(m_targetCam != null)
		{
			m_targetCam.setExposureManual(exposure);
		}
	}
	
	public void setBrightness(int brightness)
	{
		if(m_targetCam != null)
		{
			m_targetCam.setBrightness(brightness);
		}
	}
	
	public void setExposureAuto()
	{
		if(m_targetCam != null)
		{
			m_targetCam.setExposureAuto();
		}
	}
	
	public void setExposureHoldCurrent()
	{
		if(m_targetCam != null)
		{
			m_targetCam.setExposureHoldCurrent();
		}
	}
	
	public void setExposureValueFromPrefs()
	{
		setExposure(Preferences.getInstance().getInt("camExposure", 50));
	}
	
	public void setBrightnessValueFromPrefs()
	{
		setBrightness(Preferences.getInstance().getInt("camBrightness", 50));
	}
	
	public void start()
	{
		// Attempt to set the camera parameters (exposure and brightness) to the preferred values
		setCameraConfigFromPrefsWithoutCapture();
		
		// assume that the camera has been configured, now launch the image processing pipeline
		launchImageProcessing();
	}
	
	
	public void setCameraConfigFromPrefsWithoutCapture()
	{
		if(m_targetCam != null)
		{
			m_targetCam.openCamera();
			setExposureValueFromPrefs();
			setBrightnessValueFromPrefs();
			m_targetCam.updateSettings();
			m_targetCam.closeCamera();
		}
	}
	
	public void launchImageProcessing()
	{
		int pid = -1;
		ProcessBuilder pb = new ProcessBuilder("/usr/local/frc/JRE/bin/java","-jar", "/home/lvuser/grip.jar", "/home/lvuser/project.grip");

		try {
			// launch the GRIP process and then get it's PID
			Process process = pb.inheritIO().start();
			pid = getPid(process);
        } catch (IOException e) {
            e.printStackTrace();
        }
		
		// save the PID of the GRIP process - will be used later to kill the process if needed
		Preferences.getInstance().putInt("ImageProcessingPID", pid);
	}
		
	public void killImageProcessing()
	{
		int pid = Preferences.getInstance().getInt("ImageProcessingPID", -1);
		if(pid != -1)
		{
			ProcessBuilder pb = new ProcessBuilder("kill", "-9", String.valueOf(pid));
			try
			{
				pb.inheritIO().start();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}
	
	private int getPid(Process process) 
	{
	    try {
	        Class<?> cProcessImpl = process.getClass();
	        Field fPid = cProcessImpl.getDeclaredField("pid");
	        if (!fPid.isAccessible()) {
	            fPid.setAccessible(true);
	        }
	        return fPid.getInt(process);
	    } catch (Exception e) {
	        return -1;
	    }
	}

}
