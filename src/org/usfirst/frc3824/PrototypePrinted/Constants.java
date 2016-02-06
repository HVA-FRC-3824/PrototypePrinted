package org.usfirst.frc3824.PrototypePrinted;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Constants
{
	// Set the robot configuration (competition or practice)
	static final boolean IS_COMP_ROBOT = false;

	public static void InitConstants()
	{
		if (IS_COMP_ROBOT)
		{
			SmartDashboard.putString("Active Robot Values", "COMPETITION");
		}
		else // ---------- PRACTICE ROBOT ----------
		{
			SmartDashboard.putString("Active Robot Values", "PRACTICE");
		}
	}

	// ***************************************************************************************
	// Drive train turn constants
	public static double DRIVETRAIN_DRIVE_STRAIGHT_P           = 0.1;
	public static double DRIVETRAIN_DRIVE_STRAIGHT_I           = 0.0;
	public static double DRIVETRAIN_DRIVE_STRAIGHT_D           = 0.0;

	// ***************************************************************************************
	// Image turn constants
	public static double IMAGE_TURN_P                          = 2.0;	// Preference name: ImageTurn_P
	public static double IMAGE_TURN_I                          = 0.0;	// Preference name: ImageTurn_I
	public static double IMAGE_TURN_D                          = 0.6;	// Preference name: ImageTurn_D
																		// Preference name: ImageTurn_MaxAbsOutput
	
	// ***************************************************************************************
	// Shooter Elevation constants
	public static double SHOOTER_ELEVATION_SETPOINT_MIN        = .30;
	public static double SHOOTER_ELEVATION_SETPOINT_MAX        = .88;

	// ***************************************************************************************
	// Shooter Wheel Speed constants
	public static double SHOOTER_WHEEL_MIN_MULTIPLIER          = 1.0;
	public static double SHOOTER_WHEEL_MAX_MULTIPLIER          = 1.5;
	public static double SHOOTER_WHEEL_TELEOP_CURVE_MULTIPLIER = 0.5;
}
