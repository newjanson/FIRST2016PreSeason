package org.usfirst.frc2609.BendGate;
    
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
    public static DoubleSolenoid topGripperDoubleSolenoid1;
    public static DoubleSolenoid bottomGripperDoubleSolenoid1;
    public static Encoder elevatorQuadratureEncoder1;
    public static CANTalon elevatorCANTalonLeft;
    public static CANTalon elevatorCANTalonRight;
    public static CANTalon driveCANTalonLF;
    public static CANTalon driveCANTalonLR;
    public static CANTalon driveCANTalonRF;
    public static CANTalon driveCANTalonRR;
    public static RobotDrive RobotDrive4;
    public static Encoder drivequadratureEncoderLeft;
    public static Encoder drivequadratureEncoderRight;
    public static Gyro driveGyro1;
    public static SpeedController rollersrollerLeft;
    public static SpeedController rollersrollerRight;

    public static void init() {
        topGripperDoubleSolenoid1 = new DoubleSolenoid(10, 0, 1);      
        LiveWindow.addActuator("topGripper", "Double Solenoid 1", topGripperDoubleSolenoid1);
        
        bottomGripperDoubleSolenoid1 = new DoubleSolenoid(10, 2, 3);      
        LiveWindow.addActuator("bottomGripper", "Double Solenoid 1", bottomGripperDoubleSolenoid1);
        
        elevatorQuadratureEncoder1 = new Encoder(0, 2, false, EncodingType.k4X);
        LiveWindow.addSensor("Elevator", "Quadrature Encoder 1", elevatorQuadratureEncoder1);
        elevatorQuadratureEncoder1.setDistancePerPulse(1.0);
        elevatorQuadratureEncoder1.setPIDSourceParameter(PIDSourceParameter.kRate);
        elevatorCANTalonLeft = new CANTalon(5);
        elevatorCANTalonRight = new CANTalon(7);
        
        
        driveCANTalonLF = new CANTalon(3);
        driveCANTalonLR = new CANTalon(4);
        driveCANTalonRF = new CANTalon(1);
        driveCANTalonRR = new CANTalon(2);
        RobotDrive4 = new RobotDrive(driveCANTalonLF, driveCANTalonLR, driveCANTalonRF, driveCANTalonRR);
        RobotDrive4.setSafetyEnabled(true);
        RobotDrive4.setExpiration(0.1);
        RobotDrive4.setSensitivity(0.5);
        RobotDrive4.setMaxOutput(1.0);
        RobotDrive4.setInvertedMotor(RobotDrive.MotorType.kFrontLeft, false);
        RobotDrive4.setInvertedMotor(RobotDrive.MotorType.kRearLeft, false);
        RobotDrive4.setInvertedMotor(RobotDrive.MotorType.kFrontRight, true);
        RobotDrive4.setInvertedMotor(RobotDrive.MotorType.kRearRight, true);
        drivequadratureEncoderLeft = new Encoder(4, 6, false, EncodingType.k4X);
        LiveWindow.addSensor("Drive", "quadratureEncoderLeft", drivequadratureEncoderLeft);
        drivequadratureEncoderLeft.setDistancePerPulse(1.0);
        drivequadratureEncoderLeft.setPIDSourceParameter(PIDSourceParameter.kRate);
        drivequadratureEncoderRight = new Encoder(1, 3, true, EncodingType.k4X);
        LiveWindow.addSensor("Drive", "quadratureEncoderRight", drivequadratureEncoderRight);
        drivequadratureEncoderRight.setDistancePerPulse(1.0);
        drivequadratureEncoderRight.setPIDSourceParameter(PIDSourceParameter.kRate);
        driveGyro1 = new Gyro(0);
        LiveWindow.addSensor("Drive", "Gyro 1", driveGyro1);
        driveGyro1.setSensitivity(0.007);
        
        rollersrollerLeft = new Talon(1);
        LiveWindow.addActuator("Rollers", "rollerLeft", (Talon) rollersrollerLeft);
        rollersrollerRight = new Talon(2);
        LiveWindow.addActuator("Rollers", "rollerRight", (Talon) rollersrollerRight);
        
    }
}
