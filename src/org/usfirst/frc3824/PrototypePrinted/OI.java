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

import org.usfirst.frc3824.PrototypePrinted.commands.*;
import org.usfirst.frc3824.PrototypePrinted.subsystems.*;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton joystickTriggerReleased;
    public JoystickButton joystickTriggerPressed;
    public JoystickButton shooterExtend;
    public JoystickButton shooterRetract;
    public Joystick driveJoystick;
    public Joystick controllerJoystick;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

	public OI()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        controllerJoystick = new Joystick(1);
        
        driveJoystick = new Joystick(0);
        
        shooterRetract = new JoystickButton(driveJoystick, 1);
        shooterRetract.whenReleased(new ShooterShoot(false));
        shooterExtend = new JoystickButton(driveJoystick, 1);
        shooterExtend.whenPressed(new ShooterShoot(true));
        joystickTriggerPressed = new JoystickButton(driveJoystick, 4);
        joystickTriggerPressed.whenPressed(new ShiftGear(true));
        joystickTriggerReleased = new JoystickButton(driveJoystick, 4);
        joystickTriggerReleased.whenReleased(new ShiftGear(false));


        // SmartDashboard Buttons
        SmartDashboard.putData("AutonomousDoNothing", new AutonomousDoNothing());
        SmartDashboard.putData("Autonomous Low Bar Shoot Boulder", new AutonomousLowBarShootBoulder());
        SmartDashboard.putData("TeleopDrive", new TeleopDrive());
        SmartDashboard.putData("Chassis Drive Straight", new ChassisDriveStraight());
        SmartDashboard.putData("Chassis Drive Straight Distance: FourFeet", new ChassisDriveStraightDistance(48.0));
        SmartDashboard.putData("Chassis Drive Target LIDAR: BaseOfTower", new ChassisDriveTargetLIDAR(100.0));
        SmartDashboard.putData("Chassis Turn Angle: Turn90", new ChassisTurnAngle(90.0, 0.6));
        SmartDashboard.putData("ShiftGear: highGear", new ShiftGear(false));
        SmartDashboard.putData("Shooter Shoot: ShootControl", new ShooterShoot(false));
        SmartDashboard.putData("Shooter Elevation Control", new ShooterElevationControl());
        SmartDashboard.putData("Shooter Wheel Speed Control", new ShooterWheelSpeedControl());
        SmartDashboard.putData("Shoot Boulder In Goal: ShootLowGoal", new ShootBoulderInGoal(0.2, 0.5));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
	}

	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getDriveJoystick() {
        return driveJoystick;
    }

    public Joystick getControllerJoystick() {
        return controllerJoystick;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}
