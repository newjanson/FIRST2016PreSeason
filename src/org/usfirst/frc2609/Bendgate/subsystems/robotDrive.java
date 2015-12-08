package org.usfirst.frc2609.Bendgate.subsystems;
import org.usfirst.frc2609.Bendgate.OI;
import org.usfirst.frc2609.Bendgate.RobotMap;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Gyro;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.SerialPort;


public class robotDrive extends PIDSubsystem {
	
	public static AHRS ahrs;
    CANTalon canTalonLF = RobotMap.canTalonLF;
    CANTalon canTalonLR = RobotMap.canTalonLR;
    CANTalon canTalonRF = RobotMap.canTalonRF;
    CANTalon canTalonRR = RobotMap.canTalonRR;
    RobotDrive robotDrive = RobotMap.robotDrive;
    Encoder encoderLeftDrive = RobotMap.encoderLeftDrive;
    Encoder encoderRightDrive = RobotMap.encoderRightDrive;
    Gyro GyroOne = RobotMap.GyroOne;
    public double robotDriveHeading;

    public robotDrive() {
        super("robotDrive", 0.05, 0.0, 0.0);
        try {
        	ahrs = new AHRS(SerialPort.Port.kMXP);
        }
    	catch (RuntimeException ex ) {
            DriverStation.reportError("Error instantiating navX MXP:  " + ex.getMessage(), true);
        }
        setAbsoluteTolerance(20);
        getPIDController().setContinuous(true);
        LiveWindow.addActuator("robotDrive", "PIDSubsystem Controller", getPIDController());
    }
    
    public void initDefaultCommand() {    
    }
    
    public void bendDrive(){
    	robotDrive.arcadeDrive(OI.driverPad.getRawAxis(1), OI.driverPad.getRawAxis(0), true);
    }
    
    public void bendTurn(){
    	//robotDrive.arcadeDrive(0,-robotDriveHeading);
    	robotDrive.arcadeDrive(0,(ahrs.getYaw()-robotDriveHeading)*-0.01); //Turn with navX heading info
    }
    
    public void stopDrive(){
    	robotDrive.arcadeDrive(0, 0);
    }
    
    public void driveReset(){
    	encoderLeftDrive.reset();
    	encoderRightDrive.reset();
    	ahrs.zeroYaw();
    }
    
    protected double returnPIDInput() {
        return ((encoderLeftDrive.get()+(encoderRightDrive.get())*.5));
    }
    
    protected void usePIDOutput(double output) { //For autonomous use only
    	//robotDrive.tankDrive(-output, -output);
    	robotDrive.tankDrive(-output+(ahrs.getYaw()*0.05), -output-(ahrs.getYaw()*0.05));//Drive with navX heading info
    }

	public static void arcadeDrive(double rawAxis, double rawAxis2, boolean b) {
		// TODO Auto-generated method stub
	}
}
