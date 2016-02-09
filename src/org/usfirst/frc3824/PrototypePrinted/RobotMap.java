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

import org.usfirst.frc3824.PrototypePrinted.utilities.Lidar;
import org.usfirst.frc3824.PrototypePrinted.utilities.USBCamera;

// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.AnalogGyro;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PowerDistributionPanel;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.TalonSRX;
import edu.wpi.first.wpilibj.VictorSP;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap
{
	// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public static AnalogGyro chassisGyro;
    public static CANTalon chassisRightMotorB;
    public static CANTalon chassisRightMotorA;
    public static CANTalon chassisLeftMotorA;
    public static CANTalon chassisLeftMotorB;
    public static RobotDrive chassisWCDrive4;
    public static Compressor chassisCompressor;
    public static Solenoid chassisTransmission;
    public static PowerDistributionPanel powerPowerDistributionPanel;
    public static SpeedController shooterWheelRight;
    public static SpeedController shooterWheelLeft;
    public static Solenoid shooterBallShooter;
    public static AnalogPotentiometer shooterAngleAnalogPotentiometer;
    public static SpeedController shooterAngleSpeedController;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public static Lidar chassisLidar;
    
	public static void init()
	{
		// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassisGyro = new AnalogGyro(0);
        LiveWindow.addSensor("Chassis", "Gyro", chassisGyro);
        chassisGyro.setSensitivity(0.007);
        chassisRightMotorB = new CANTalon(2);
        LiveWindow.addActuator("Chassis", "Right Motor B", chassisRightMotorB);
        
        chassisRightMotorA = new CANTalon(3);
        LiveWindow.addActuator("Chassis", "Right Motor A", chassisRightMotorA);
        
        chassisLeftMotorA = new CANTalon(1);
        LiveWindow.addActuator("Chassis", "Left Motor A", chassisLeftMotorA);
        
        chassisLeftMotorB = new CANTalon(0);
        LiveWindow.addActuator("Chassis", "Left Motor B", chassisLeftMotorB);
        
        chassisWCDrive4 = new RobotDrive(chassisLeftMotorA, chassisLeftMotorB,
              chassisRightMotorA, chassisRightMotorB);
        
        chassisWCDrive4.setSafetyEnabled(true);
        chassisWCDrive4.setExpiration(0.1);
        chassisWCDrive4.setSensitivity(0.5);
        chassisWCDrive4.setMaxOutput(1.0);
        chassisWCDrive4.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        chassisWCDrive4.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        chassisWCDrive4.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        chassisWCDrive4.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        chassisCompressor = new Compressor(0);
        
        
        chassisTransmission = new Solenoid(0, 2);
        LiveWindow.addActuator("Chassis", "Transmission", chassisTransmission);
        
        powerPowerDistributionPanel = new PowerDistributionPanel(0);
        LiveWindow.addSensor("Power", "PowerDistributionPanel", powerPowerDistributionPanel);
        
        shooterWheelRight = new TalonSRX(0);
        LiveWindow.addActuator("Shooter", "Wheel Right", (TalonSRX) shooterWheelRight);
        
        shooterWheelLeft = new TalonSRX(1);
        LiveWindow.addActuator("Shooter", "Wheel Left", (TalonSRX) shooterWheelLeft);
        
        shooterBallShooter = new Solenoid(0, 1);
        LiveWindow.addActuator("Shooter", "Ball Shooter", shooterBallShooter);
        
        shooterAngleAnalogPotentiometer = new AnalogPotentiometer(1, 1.0, 0.0);
        LiveWindow.addSensor("Shooter Angle", "Analog Potentiometer", shooterAngleAnalogPotentiometer);
        
        shooterAngleSpeedController = new VictorSP(2);
        LiveWindow.addActuator("Shooter Angle", "Speed Controller", (VictorSP) shooterAngleSpeedController);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        chassisLidar = new Lidar(0, 1);
	}
}
