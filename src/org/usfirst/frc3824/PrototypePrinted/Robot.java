// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.

package org.usfirst.frc3824.PrototypePrinted;

import org.usfirst.frc3824.PrototypePrinted.Robot;
import org.usfirst.frc3824.PrototypePrinted.RobotMap;
import org.usfirst.frc3824.PrototypePrinted.Constants;
import org.usfirst.frc3824.PrototypePrinted.commands.*;
import org.usfirst.frc3824.PrototypePrinted.subsystems.*;

import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Robot extends IterativeRobot
{
	Command autonomousCommand;

	public static OI oi;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static Chassis chassis;
    public static Power power;
    public static TargetCam targetCam;
    public static Shooter shooter;
    public static ShooterAngle shooterAngle;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public static SendableChooser chooser;

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	public void robotInit()
	{
		// Initialize the robot constants
		Constants.InitConstants();

		// Initialize the robot components
		RobotMap.init();

		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassis = new Chassis();
        power = new Power();
        targetCam = new TargetCam();
        shooter = new Shooter();
        shooterAngle = new ShooterAngle();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
		// OI must be constructed after subsystems. If the OI creates Commands
		// (which it very likely will), subsystems are not guaranteed to be
		// constructed yet. Thus, their requires() statements may grab null
		// pointers. Bad news. Don't move it.
		oi = new OI();

		// instantiate the command used for the autonomous period
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=AUTONOMOUS

		chooser = new SendableChooser();
		chooser.addDefault("1) Do Nothing", new AutonomousDoNothing());

		// RobotMap.chassisCompressor.start();
		RobotMap.chassisCompressor.setClosedLoopControl(true);
	}

	/**
	 * This function is called when the disabled button is hit. You can use it
	 * to reset subsystems before shutting down.
	 */
	public void disabledInit()
	{

	}

	public void disabledPeriodic()
	{
		Scheduler.getInstance().run();
	}

	public void autonomousInit()
	{
		// Determine the autonomous command
		if (chooser.getSelected() != null)
		{
			// Reset the gyro before the start of autonomous
			Robot.chassis.resetGyro();

			// Get the autonomous command
			autonomousCommand = (edu.wpi.first.wpilibj.command.Command) chooser.getSelected();

			// schedule the autonomous command
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous
	 */
	public void autonomousPeriodic()
	{
		Scheduler.getInstance().run();

		// Add current gyro angle to smart dashboard
		SmartDashboard.putNumber("Gyro Angle", Robot.chassis.getGyro().getAngle());
		
		SmartDashboard.putNumber("Lidar Range (cm)", Robot.chassis.getLidarDistanceCentimeters());
	}

	public void teleopInit()
	{
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (autonomousCommand != null)
			autonomousCommand.cancel();
	}

	/**
	 * This function is called periodically during operator control
	 */
	public void teleopPeriodic()
	{
		Scheduler.getInstance().run();
		SmartDashboard.putBoolean("Compressor Enabled", RobotMap.chassisCompressor.enabled());
		SmartDashboard.putBoolean("Pressure Switch", RobotMap.chassisCompressor.getPressureSwitchValue());
		SmartDashboard.putNumber("Compressor Current", RobotMap.chassisCompressor.getCompressorCurrent());
		
		SmartDashboard.putNumber("Lidar Range (cm)", Robot.chassis.getLidarDistanceCentimeters());
	}

	/**
	 * This function is called periodically during test mode
	 */
	public void testPeriodic()
	{
		LiveWindow.run();
	}
}
