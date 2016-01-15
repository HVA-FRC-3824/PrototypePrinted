// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc3824.PrototypeRobot;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static AnalogGyro chassisGyro;
    public static SpeedController chassisMotorLeftA;
    public static SpeedController chassisMotorLeftB;
    public static SpeedController chassisMotorRightA;
    public static SpeedController chassisMotorRightB;
    public static RobotDrive chassisWCDrive4;
    public static PowerDistributionPanel powerPowerDistributionPanel;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static void init() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassisGyro = new AnalogGyro(0);
        LiveWindow.addSensor("Chassis", "Gyro", chassisGyro);
        chassisGyro.setSensitivity(0.007);
        chassisMotorLeftA = new Talon(0);
        LiveWindow.addActuator("Chassis", "Motor Left A", (Talon) chassisMotorLeftA);
        
        chassisMotorLeftB = new Talon(1);
        LiveWindow.addActuator("Chassis", "Motor Left B", (Talon) chassisMotorLeftB);
        
        chassisMotorRightA = new Talon(2);
        LiveWindow.addActuator("Chassis", "Motor Right A", (Talon) chassisMotorRightA);
        
        chassisMotorRightB = new Talon(3);
        LiveWindow.addActuator("Chassis", "Motor Right B", (Talon) chassisMotorRightB);
        
        chassisWCDrive4 = new RobotDrive(chassisMotorLeftA, chassisMotorLeftB,
              chassisMotorRightA, chassisMotorRightB);
        
        chassisWCDrive4.setSafetyEnabled(true);
        chassisWCDrive4.setExpiration(0.1);
        chassisWCDrive4.setSensitivity(0.5);
        chassisWCDrive4.setMaxOutput(1.0);

        powerPowerDistributionPanel = new PowerDistributionPanel(0);
        LiveWindow.addSensor("Power", "PowerDistributionPanel", powerPowerDistributionPanel);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
}
