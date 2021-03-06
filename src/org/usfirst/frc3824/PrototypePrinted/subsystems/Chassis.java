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

import org.usfirst.frc3824.PrototypePrinted.RobotMap;
import org.usfirst.frc3824.PrototypePrinted.commands.*;
import org.usfirst.frc3824.PrototypePrinted.utilities.Lidar;
import org.usfirst.frc3824.PrototypePrinted.Constants;
import org.usfirst.frc3824.PrototypePrinted.Robot;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Robot Chassis subsystem class
 */
public class Chassis extends Subsystem
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final AnalogGyro gyro = RobotMap.chassisGyro;
    private final CANTalon rightMotorB = RobotMap.chassisRightMotorB;
    private final CANTalon rightMotorA = RobotMap.chassisRightMotorA;
    private final CANTalon leftMotorA = RobotMap.chassisLeftMotorA;
    private final CANTalon leftMotorB = RobotMap.chassisLeftMotorB;
    private final RobotDrive wCDrive4 = RobotMap.chassisWCDrive4;
    private final Compressor compressor = RobotMap.chassisCompressor;
    private final Solenoid transmission = RobotMap.chassisTransmission;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    private final Lidar lidar = RobotMap.chassisLidar;
    
	// Parameters used for drive while running under PIDControl. The values
	// not set by the controller constructor can be set by a command directly
	private double magnitude;
	private double direction;

	// Declare the PID Output class prototype
	// (See class at the end of the source file)
	private AnglePIDOutput angleOutput = new AnglePIDOutput();

	// Instantiate the PID controller for driving in the specified direction
	private PIDController angleGyroController = new PIDController(Constants.DRIVETRAIN_DRIVE_STRAIGHT_P, 
	                                                              Constants.DRIVETRAIN_DRIVE_STRAIGHT_I, 
	                                                              Constants.DRIVETRAIN_DRIVE_STRAIGHT_D, 
	                                                              gyro, angleOutput);

	/**
	 * Method to set the default command for the Chassis
	 */
	public void initDefaultCommand()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new TeleopDrive());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	}

	/**
	 * Method to control the drive through the specified joystick
	 */
	public void driveWithJoystick(Joystick stick)
	{
		// Drive with arcade with the Y axis for forward/backward and
		// steer with twist
		wCDrive4.arcadeDrive(stick.getY(), stick.getTwist(), false);
	}

	/**
	 * Method to stop the chassis drive motors
	 */
	public void stop()
	{
		// Stop all motors
		wCDrive4.arcadeDrive(0, 0);
	}

	/**
	 * Method to shift the drive train
	 */
	public void shiftGear(boolean gearHigh)
	{
		// Control the gear shift piston
		transmission.set(gearHigh);
	}

	/**
	 * Method to return a reference to the Robot Drive
	 */
	public RobotDrive getRobotDrive()
	{
		// Return a reference to the Robot Drive
		return(wCDrive4);
	}
	
	/**
	 * Method to return a reference to the chassis gyro
	 */
	public AnalogGyro getGyro()
	{
		// Return a reference to the gryo
		return (gyro);
	}

	/**
	 * Method to return the present gyro angle
	 */
	public double getGyroValue()
	{
		// Return the gyro angle
		return (gyro.getAngle());
	}

	/**
	 * Method to return a relative gyro angle (between 0 and 360)
	 */
	public double getRelativeAngle()
	{
		// Get the present angle
		double absAngle = gyro.getAngle();

		// Adjust the angle if negative
		while (absAngle < 0.0)
			absAngle += 360.0;

		// Adjust the angle if greater than 360
		while (absAngle >= 360.0)
			absAngle -= 360.0;

		// Return the angle between 0 and 360
		return absAngle;
	}

	/**
	 * Method to reset the chassis gyro
	 */
	public void resetGyro()
	{
		// Reset the gyro (angle goes to zero)
		gyro.reset();
	}

	/**
	 * Method to set the desired chassis speed (magnitude) for PID controlled moves.
	 * Only to be used while controlled by PID controller
	 */
	public void setMagnitude(double magnitude)
	{
		this.magnitude = magnitude;
	}

	/**
	 * Method to set the desired chassis curve (angle) for PID controlled moves.
	 * Only to be used while controlled by PID controller
	 */
	public void setDirection(double direction)
	{
		// Set the desired gyro angle
		this.direction = direction;
	}

	/**
	 * Method to return a reference to the PID controller
	 */
	public PIDController getAngleGyroController()
	{
		return (angleGyroController);
	}

	/**
	 * Class declaration for the PIDOutput
	 */
	public class AnglePIDOutput implements PIDOutput
	{
		/**
		 * Virtual function to receive the PID output and set the drive direction 
		 */
		public void pidWrite(double PIDoutput)
		{	
			// Drive the robot given the speed and direction
			wCDrive4.drive(-magnitude, PIDoutput);
		}
	}
	
	//-------------------------------------------
	// Lidar commands for Chassis
	//-------------------------------------------
	public double getLidarDistanceCentimeters()
	{
		return lidar.getDistanceCentimeters();
	}
}
