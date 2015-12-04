package org.usfirst.frc2609.Bendgate.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2609.Bendgate.Robot;

public class  elevatorPoint1 extends Command {
	private String setElevator;
    public elevatorPoint1(String setElevator) {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    	this.setElevator = setElevator;
        requires(Robot.elevatorDrive);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=REQUIRES
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	Robot.elevatorDrive.enable();
    	Robot.elevatorDrive.setOutputRange(-0.4, .7);
    	if (setElevator=="position1"){
    		Robot.elevatorDrive.setSetpoint(0);
    	}
    	else if (setElevator=="position2"){
    		Robot.elevatorDrive.setSetpoint(780);
    	}
    	else if (setElevator=="position3"){
    		Robot.elevatorDrive.setSetpoint(2000);
    	}
    	else if (setElevator=="position4"){
    		Robot.elevatorDrive.setSetpoint(6666);
    	}
    	if (setElevator=="position5"){
    		Robot.elevatorDrive.setSetpoint(1800);
    	}
    	else{
    		Robot.elevatorDrive.setSetpoint(0);
    	}
        
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
        return Robot.elevatorDrive.onTarget();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=ISFINISHED
    }

    // Called once after isFinished returns true
    protected void end() {
    	//Robot.elevatorDrive.disable();
    	Robot.elevatorDrive.setOutputRange(-0.4, .6);
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
