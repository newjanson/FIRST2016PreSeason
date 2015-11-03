package org.usfirst.frc2609.Bendgate;   
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType; import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.can.*;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import java.util.Vector;

public class RobotMap {
    public static CANTalon canTalonLF;
    public static CANTalon canTalonLR;
    public static CANTalon canTalonRF;
    public static CANTalon canTalonRR;
    public static RobotDrive robotDrive;
    public static Encoder encoderLeftDrive;
    public static Encoder encoderRightDrive;
    public static Gyro gyroOne;
    public static Encoder encoderElevator;
    public static CANTalon canTalonEL;
    public static CANTalon canTalonER;
    public static DoubleSolenoid bottomGripperSolenoid;
    public static DoubleSolenoid topGripperSolenoid;
    public static SpeedController rollerLeft;
    public static SpeedController rollerRight;

    
    public static void init() {

        canTalonLF = new CANTalon(3);
        canTalonLR = new CANTalon(4);
        canTalonRF = new CANTalon(1);
        canTalonRR = new CANTalon(2);
        robotDrive = new RobotDrive(canTalonLF, canTalonLR, canTalonRF, canTalonRR);
        robotDrive.setSafetyEnabled(true);
        robotDrive.setExpiration(0.1);
        robotDrive.setSensitivity(0.5);
        robotDrive.setMaxOutput(1.0);
        
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearLeft, true);
        robotDrive.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        
        encoderLeftDrive = new Encoder(4, 6, false);
        LiveWindow.addSensor("robotDrive", "encoderLeftDrive", encoderLeftDrive);
        encoderLeftDrive.setDistancePerPulse(1.0);
        encoderLeftDrive.setPIDSourceParameter(PIDSourceParameter.kRate);
        encoderRightDrive = new Encoder(1, 3, true);
        LiveWindow.addSensor("robotDrive", "encoderRightDrive", encoderRightDrive);
        encoderRightDrive.setDistancePerPulse(1.0);
        encoderRightDrive.setPIDSourceParameter(PIDSourceParameter.kRate);
        
        gyroOne = new Gyro(0);
        LiveWindow.addSensor("robotDrive", "gyroOne", gyroOne);
        gyroOne.setSensitivity(0.007);
        
        encoderElevator = new Encoder(0, 2, false);
        LiveWindow.addSensor("elevatorDrive", "encoderElevator", encoderElevator);
        encoderElevator.setDistancePerPulse(1.0);
        encoderElevator.setPIDSourceParameter(PIDSourceParameter.kRate);
        
        canTalonEL = new CANTalon(6);
        canTalonER = new CANTalon(7);

        bottomGripperSolenoid = new DoubleSolenoid(10, 2, 3);      
        LiveWindow.addActuator("bottomGripper", "bottomGripperSolenoid", bottomGripperSolenoid);
        topGripperSolenoid = new DoubleSolenoid(10, 0, 1);      
        LiveWindow.addActuator("topGripper", "topGripperSolenoid", topGripperSolenoid);
        rollerLeft = new Talon(2);
        LiveWindow.addActuator("rollerDrive", "rollerLeft", (Talon) rollerLeft);
        rollerRight = new Talon(1);
        LiveWindow.addActuator("rollerDrive", "rollerRight", (Talon) rollerRight);
        
        
    /*  SmartDashboard.putBoolean("RightisFwdLimitSwitchClosed", cANTalonRight.isFwdLimitSwitchClosed());	//Top Right
    	SmartDashboard.putBoolean("RightisRevLimitSwitchClosed", cANTalonRight.isRevLimitSwitchClosed());	//Bot Right
    	SmartDashboard.putBoolean("LeftisFwdLimitSwitchClosed", cANTalonLeft.isFwdLimitSwitchClosed());		//Bot Left
    	SmartDashboard.putBoolean("LeftisRevLimitSwitchClosed", cANTalonLeft.isRevLimitSwitchClosed());		//Top Left
    */    
        
        
        
    	

    }
}
