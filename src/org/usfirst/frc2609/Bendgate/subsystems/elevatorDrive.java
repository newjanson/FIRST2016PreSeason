package org.usfirst.frc2609.Bendgate.subsystems;
import org.usfirst.frc2609.Bendgate.OI;
import org.usfirst.frc2609.Bendgate.Robot;
import org.usfirst.frc2609.Bendgate.RobotMap;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class elevatorDrive extends PIDSubsystem {
    Encoder encoderElevator = RobotMap.encoderElevator;
    CANTalon cANTalonLeft = RobotMap.canTalonEL;
    CANTalon cANTalonRight = RobotMap.canTalonER;
    Boolean toggle = true;
    Boolean oldButton = false;
    Boolean switch1 = true;
    public elevatorDrive() {
        super("elevatorDrive", .003, 0.0, 0.0);
        setAbsoluteTolerance(20);
        getPIDController().setContinuous(false);
        LiveWindow.addActuator("elevatorDrive", "PIDSubsystem Controller", getPIDController());
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void elevatorReset(){
    	encoderElevator.reset();
    }
    
    public void elevatorStick(){
    	if (OI.operatorPad.getRawButton(9) == true){
	    	if (Math.abs(OI.operatorPad.getRawAxis(5))>.2){  
	    		if(encoderElevator.get() < 6366 || encoderElevator.get() > 300){
	    			Robot.elevatorDrive.enable();
	    	    	Robot.elevatorDrive.setSetpoint(encoderElevator.get()+(300*-OI.operatorPad.getRawAxis(5)));
	    		}
	    		else{
	    			Robot.elevatorDrive.enable();
	    	    	Robot.elevatorDrive.setSetpoint(encoderElevator.get()+(50*-OI.operatorPad.getRawAxis(5)));
	    		}
	    	}
	    	else{
	    		if (OI.operatorPad.getRawButton(1)==true || OI.operatorPad.getRawButton(2)==true || OI.operatorPad.getRawButton(3)==true || OI.operatorPad.getRawButton(4)==true){
	    			Robot.elevatorDrive.enable();
	    		}
	    		else{
	    			Robot.elevatorDrive.disable();
	    		}
	    	}
    	
    	}
    	SmartDashboard.putNumber("encoderElevator", encoderElevator.get());
    }
    
    public void initDefaultCommand() {
        //setDefaultCommand(new elevatorStick());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
        return encoderElevator.get();
    }
    
    protected void usePIDOutput(double output) {
    	if (cANTalonLeft.isFwdLimitSwitchClosed()==true || cANTalonRight.isRevLimitSwitchClosed()==true){
    		encoderElevator.reset();
    	}
    	/*
    	SmartDashboard.putNumber("encoder", quadratureEncoder1.get());
    	SmartDashboard.putBoolean("RightisFwdLimitSwitchClosed", cANTalonRight.isFwdLimitSwitchClosed());
    	SmartDashboard.putBoolean("RightisRevLimitSwitchClosed", cANTalonRight.isRevLimitSwitchClosed());
    	SmartDashboard.putBoolean("LeftisFwdLimitSwitchClosed", cANTalonLeft.isFwdLimitSwitchClosed());
    	SmartDashboard.putBoolean("LeftisRevLimitSwitchClosed", cANTalonLeft.isRevLimitSwitchClosed());
        */
    	cANTalonLeft.set(-output);
        cANTalonRight.set(output);
    }
}
