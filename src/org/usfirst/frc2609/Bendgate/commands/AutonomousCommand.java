package org.usfirst.frc2609.Bendgate.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2609.Bendgate.Robot;
import org.usfirst.frc2609.Bendgate.commands.*;

/**
 *
 */
public class  AutonomousCommand extends CommandGroup {

    public AutonomousCommand() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    	//addSequential(new driveDistanceEncoder());
    	int i = 1;
    	while(i <= 2)
    	{
    		addSequential(new rollerIn());
    		addSequential(new openTopGripper());
    		addSequential(new timerDelay(500));
    		addSequential(new elevatorPoint1());
    		addSequential(new timerDelay(500));
    		addSequential(new closeBottomGripper());
    		addSequential(new timerDelay(500));
    		addSequential(new closeTopGripper());
    		addSequential(new openBottomGripper());
    		addSequential(new timerDelay(400));
    		addSequential(new elevatorPoint4());
    		addSequential(new timerDelay(500));
    		addSequential(new closeBottomGripper());
    		addSequential(new timerDelay(750));
    		addSequential(new elevatorPoint3());
    		addSequential(new timerDelay(750));
    		i++;
    	}
    	addSequential(new rollerStop());
    	//Tote 2 beings
    	/*
    	addSequential(new closeTopGripper());
    	addSequential(new timerDelay(500));
    	addSequential(new openBottomGripper());
    	addSequential(new elevatorPoint4());
    	addSequential(new timerDelay(1000));
    	addSequential(new elevatorPoint3());
    	addSequential(new closeBottomGripper());
    	addSequential(new timerDelay(500));
    	addSequential(new rollerStop());*/
    	
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
