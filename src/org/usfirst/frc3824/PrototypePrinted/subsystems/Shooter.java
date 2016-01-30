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
import org.usfirst.frc3824.PrototypePrinted.Constants;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 *
 */
public class Shooter extends Subsystem
{
	private boolean m_enabled;

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private final SpeedController wheelRight = RobotMap.shooterWheelRight;
    private final SpeedController wheelLeft = RobotMap.shooterWheelLeft;
    private final Solenoid ballShooter = RobotMap.shooterBallShooter;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	// Put methods for controlling this subsystem
	// here. Call these from Commands.

	public void initDefaultCommand()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

		// Set the default command for a subsystem here.
		// setDefaultCommand(new MySpecialCommand());
	}

	/**
	 * Method to enable or disable the shooter wheels. Note: The actual control
	 * of the shooter wheels is in the default ShooterControl command.
	 */
	public void ShooterWheelEnableDisable(boolean enable)
	{
		// Remember the requested state of the shooter wheels
		m_enabled = enable;
		SmartDashboard.putBoolean("Shooter Enabled", enable);
	}

	/**
	 * Method to determine if the shooter wheels are enabled
	 */
	public boolean IsShooterWheelEnabled()
	{
		// Return the state of the shooter wheels
		return (m_enabled);
	}

	/**
	 * Method to enable the shooter with the specified speed. The method can
	 * also disable the shooter with a speed of zero.
	 */
	public void ShooterWheelControl(double speed)
	{
		// Set the shooter wheel motor speeds
		// Note: The multiplier is to ensure maximum speed is reached
		// The multiplier also reduces the minimum speed
		if (speed<0)
		{
			wheelRight.set(speed * Constants.SHOOTER_WHEEL_MIN_MULTIPLIER);
			wheelLeft.set(speed * Constants.SHOOTER_WHEEL_MIN_MULTIPLIER);
		} else {
			wheelRight.set(speed * Constants.SHOOTER_WHEEL_MAX_MULTIPLIER);
			wheelLeft.set(speed * Constants.SHOOTER_WHEEL_MAX_MULTIPLIER);			
		}
	}

	/**
	 * Method to shoot the ball
	 */
	public void ShooterShootBallControl(boolean state)
	{
		// Control the gear shift piston
		ballShooter.set(state);
	}
}
