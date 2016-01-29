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

import org.usfirst.frc3824.PrototypePrinted.Robot;
import org.usfirst.frc3824.PrototypePrinted.RobotMap;
import org.usfirst.frc3824.PrototypePrinted.commands.*;
import org.usfirst.frc3824.PrototypePrinted.utilities.USBCamera;

import com.ni.vision.NIVision;

import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.Preferences;
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

	private final USBCamera targetCam = RobotMap.shooterTargetCam;
	private NIVision.Image singleFrame;
	private int m_exposure;
	private int m_brightness;
	
	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public TargetCam()
	{
		singleFrame = NIVision.imaqCreateImage(NIVision.ImageType.IMAGE_RGB, 0);
		//CameraServer.getInstance().startAutomaticCapture(targetCam);
		targetCam.startCapture();
	}
	
	
	public class Targets
	{
		
	}
	
	public void initDefaultCommand()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new ConfigureCamera(true));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}
	
//	Targets GetCurrentTargets()
//	{
//		return void;
//	}
		
	public void updateDashboardImage()
	{
		// targetCam.updateSettings();
		// targetCam.startCapture();
		//for(int i=0; i<1000; i++);
		targetCam.getImage(singleFrame);
		CameraServer.getInstance().setImage(singleFrame);
		// targetCam.stopCapture();
	}
	
	public void updateValuesOnDashboard()
	{
		SmartDashboard.putString("Current Exposure Value", targetCam.getExposure());
		SmartDashboard.putString("Current Exposure Mode", targetCam.getExposureMode());		
		SmartDashboard.putNumber("Current Brightness", targetCam.getBrightness());
		SmartDashboard.putNumber("Minimum Exposure", targetCam.getExposureMin());
		SmartDashboard.putNumber("Maximum Exposure", targetCam.getExposureMax());
	}
	
	public void setExposure(int exposure)
	{
		targetCam.setExposureManual(exposure);
	}
	
	public void setBrightness(int brightness)
	{
		targetCam.setBrightness(brightness);
	}
	
	public void setExposureAuto()
	{
		targetCam.setExposureAuto();
	}
	
	public void setExposureHoldCurrent()
	{
		targetCam.setExposureHoldCurrent();
	}
}
