package org.usfirst.frc2609.BendGate.commands;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class timerDelay extends Command {
	private double setDelay;
	double varStartTime;
    public timerDelay(double setDelay){
    	this.setDelay = setDelay;
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    	//double varStartTime;
    	varStartTime = System.currentTimeMillis();
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
    	
    	if (varStartTime < (System.currentTimeMillis()- setDelay)){
    		return true;
    		}
    	else{
    		return false;
    	}
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
