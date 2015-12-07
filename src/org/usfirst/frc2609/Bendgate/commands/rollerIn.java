package org.usfirst.frc2609.Bendgate.commands;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2609.Bendgate.Robot;
import org.usfirst.frc2609.Bendgate.RobotMap;


public class  rollerIn extends Command {
    DigitalInput toteSenseR = RobotMap.toteSenseR;
    DigitalInput toteSenseL = RobotMap.toteSenseL;
    public static int counter;
    public rollerIn() {
        requires(Robot.rollerDrive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.rollerDrive.rollIn();
        if (!(toteSenseR.get() || toteSenseL.get()))
        {
        	counter++;
        }
        else{
        	counter = 0;
        }
    }

    protected boolean isFinished() {
    	if(counter == 3)
    	{
    		counter = 0;
    		return true;
    	}
    	else
    	{
    		return false;
    	}
    	
    }
    
    protected void end() {
    	Robot.rollerDrive.rollStop();
    }

    protected void interrupted() {
    }
}

