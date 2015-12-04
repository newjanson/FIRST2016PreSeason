package org.usfirst.frc2609.Bendgate.subsystems;
import org.usfirst.frc2609.Bendgate.OI;
import org.usfirst.frc2609.Bendgate.RobotMap;
import com.kauailabs.navx.frc.AHRS;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
public class robotDrive extends PIDSubsystem {
	
	public static AHRS ahrs;
    CANTalon canTalonLF = RobotMap.canTalonLF;
    CANTalon canTalonLR = RobotMap.canTalonLR;
    CANTalon canTalonRF = RobotMap.canTalonRF;
    CANTalon canTalonRR = RobotMap.canTalonRR;
    RobotDrive robotDrive = RobotMap.robotDrive;
    Encoder encoderLeftDrive = RobotMap.encoderLeftDrive;
    Encoder encoderRightDrive = RobotMap.encoderRightDrive;
    Gyro gyroOne = RobotMap.gyroOne;
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
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    public void bendDrive(){
    	robotDrive.arcadeDrive(OI.driverPad.getRawAxis(1)*.6, OI.driverPad.getRawAxis(0)*.6, true);
    	/*
    	SmartDashboard.putNumber("ahrsGetAngleTele", ahrs.getYaw());
    	SmartDashboard.putBoolean("ahrsIsConnected", ahrs.isConnected());
        SmartDashboard.putNumber("encoderRightWheel", encoderRightDrive.get());
        SmartDashboard.putNumber("encoderLeftWheel", encoderLeftDrive.get());
        */
    }
    
    public void bendTurn(){
    	robotDrive.arcadeDrive(0,(ahrs.getYaw()-robotDriveHeading)*-0.01);
    	/*
    	SmartDashboard.putNumber("ahrsGetAngleTele", ahrs.getYaw());
    	SmartDashboard.putBoolean("ahrsIsConnected", ahrs.isConnected());
        SmartDashboard.putNumber("encoderRightWheel", encoderRightDrive.get());
        SmartDashboard.putNumber("encoderLeftWheel", encoderLeftDrive.get());
        */
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
    
    protected void usePIDOutput(double output) {
    	robotDrive.tankDrive(-output+(ahrs.getYaw()*0.05), -output-(ahrs.getYaw()*0.05));
        //canTalonLF.set(output);
        //canTalonLR.set(output);
        //canTalonRF.set(-output);
        //canTalonRR.set(-output);
    	/*
        SmartDashboard.putNumber("ahrsGetAngleAuto", gyroOne.getAngle());
        SmartDashboard.putBoolean("ahrsIsConnected", ahrs.isConnected());
        SmartDashboard.putNumber("encoderRightWheel", encoderRightDrive.get());
        SmartDashboard.putNumber("encoderLeftWheel", encoderLeftDrive.get());
        */
    }

	public static void arcadeDrive(double rawAxis, double rawAxis2, boolean b) {
		// TODO Auto-generated method stub
		
	}
}
