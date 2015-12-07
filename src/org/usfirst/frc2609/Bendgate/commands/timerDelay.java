package org.usfirst.frc2609.Bendgate.commands;
import edu.wpi.first.wpilibj.command.Command;

public class timerDelay extends Command {
	private double setDelay;
	double varStartTime;
    public timerDelay(double setDelay){
    	this.setDelay = setDelay;

    }

    protected void initialize() {
    	varStartTime = System.currentTimeMillis();
    }

    protected void execute() {
    }

    protected boolean isFinished() {
    	if (varStartTime < (System.currentTimeMillis()- setDelay)){
    		return true;
    		}
    	else{
    		return false;
    	}
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

