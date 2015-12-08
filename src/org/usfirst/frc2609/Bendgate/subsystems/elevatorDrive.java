package org.usfirst.frc2609.Bendgate.subsystems;
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
    public void talonDrive(int setElevator){
    	Robot.elevatorDrive.disable();
    	cANTalonLeft.enableControl();
    	cANTalonLeft.set(setElevator);
    	SmartDashboard.putNumber("encoderElevator", cANTalonLeft.getPosition());
    	SmartDashboard.putNumber("encoderSetpoint", cANTalonLeft.getSetpoint());
    }
    public void talonDisable(){
    	cANTalonLeft.disable();
    	SmartDashboard.putNumber("encoderElevator", cANTalonLeft.getPosition());
    	SmartDashboard.putNumber("encoderSetpoint", cANTalonLeft.getSetpoint());
    }
    public void elevatorStick(){
    }
    
    public void initDefaultCommand() {
        //setDefaultCommand(new elevatorStick());
    }
    
    protected double returnPIDInput() {
        return cANTalonLeft.getPosition();
    }
    
    protected void usePIDOutput(double output) {
    	if (cANTalonLeft.isFwdLimitSwitchClosed()==true || cANTalonRight.isRevLimitSwitchClosed()==true){ 
    		cANTalonLeft.setPosition(0); //One or both of the bottom limit switch was pressed, set encoder to 0
    	}
    	//cANTalonLeft.set(-output);
        //cANTalonRight.set(output);
    }
}
