package org.usfirst.frc2609.Bendgate;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

public class RobotMap {
    public static CANTalon canTalonLF;
    public static CANTalon canTalonLR;
    public static CANTalon canTalonRF;
    public static CANTalon canTalonRR;
    public static RobotDrive robotDrive;
    public static Encoder encoderLeftDrive;
    public static Encoder encoderRightDrive;
    public static Gyro GyroOne;
    public static Encoder encoderElevator;
    public static CANTalon canTalonEL;
    public static CANTalon canTalonER;
    public static DoubleSolenoid bottomGripperSolenoid;
    public static DoubleSolenoid topGripperSolenoid;
    public static SpeedController rollerLeft;
    public static SpeedController rollerRight;
    public static DigitalInput toteSenseR;
    public static DigitalInput toteSenseL;
        
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

        GyroOne = new Gyro(0);
        GyroOne.setSensitivity(0.007);
        LiveWindow.addSensor("robotDrive", "GyroOne", GyroOne);

        encoderElevator = new Encoder(0, 2, false);
        LiveWindow.addSensor("elevatorDrive", "encoderElevator", encoderElevator);
        encoderElevator.setDistancePerPulse(1.0);
        encoderElevator.setPIDSourceParameter(PIDSourceParameter.kRate);
        canTalonEL = new CANTalon(6);
        canTalonEL.changeControlMode(CANTalon.ControlMode.Position);
        canTalonEL.setFeedbackDevice(CANTalon.FeedbackDevice.QuadEncoder);
        canTalonEL.reverseOutput(true);
        canTalonEL.setPID(2.0, 0.0, 0.0);
        canTalonER = new CANTalon(7);
        canTalonER.changeControlMode(CANTalon.ControlMode.Follower);
        canTalonER.set(6);
        canTalonER.reverseOutput(true);

        bottomGripperSolenoid = new DoubleSolenoid(10, 2, 3);      
        LiveWindow.addActuator("bottomGripper", "bottomGripperSolenoid", bottomGripperSolenoid);
        topGripperSolenoid = new DoubleSolenoid(10, 0, 1);      
        LiveWindow.addActuator("topGripper", "topGripperSolenoid", topGripperSolenoid);
        rollerLeft = new Talon(2);
        LiveWindow.addActuator("rollerDrive", "rollerLeft", (Talon) rollerLeft);
        rollerRight = new Talon(1);
        LiveWindow.addActuator("rollerDrive", "rollerRight", (Talon) rollerRight);
        toteSenseR = new DigitalInput(7);
        toteSenseL = new DigitalInput(8);    
    }
}
