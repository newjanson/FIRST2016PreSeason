package org.usfirst.frc2609.Bendgate.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2609.Bendgate.Robot;
import org.usfirst.frc2609.Bendgate.commands.*;

public class  AutonomousCommand extends CommandGroup {

    public AutonomousCommand() {
    	requires(Robot.bottomGripper);		// subsystem dependencies
    	requires(Robot.elevatorDrive);		// subsystem dependencies
    	requires(Robot.robotDrive);			// subsystem dependencies
    	requires(Robot.rollerDrive);		// subsystem dependencies
    	requires(Robot.topGripper);			// subsystem dependencies
    	
    	int distanceVar = 1550;
    	double speed = .5;
    	addSequential(new rollerIn());
		addSequential(new closeBottomGripper()); 
    	addSequential(new timerDelay(250));
    	addSequential(new closeTopGripper());
    	addSequential(new openBottomGripper());
    	addSequential(new timerDelay(250));
    	addSequential(new elevatorPoint4());
		addSequential(new driveDistanceEncoder(distanceVar,speed));
		distanceVar = distanceVar + distanceVar + 200;
		addSequential(new closeBottomGripper());
		addSequential(new timerDelay(500));
		addSequential(new elevatorPoint3());
		addSequential(new openTopGripper());
		addSequential(new timerDelay(250));
		addSequential(new elevatorPoint1());
		addSequential(new closeTopGripper());
		addSequential(new timerDelay(250));
		addSequential(new openBottomGripper());
		addSequential(new timerDelay(250));
		addSequential(new elevatorPoint4());
		addSequential(new driveDistanceEncoder(distanceVar,speed));
		addSequential(new closeBottomGripper());
		addSequential(new timerDelay(500));
		addSequential(new elevatorPoint3());
		addSequential(new rollerStop());
		
		addSequential(new driveAngleTurn(90));
		addSequential(new driveDistanceEncoder(2088,speed)); //164.4 inches*12.7 counts per inch = 12.94 
		addSequential(new openBottomGripper());
		addSequential(new openTopGripper());
		
		addSequential(new stopDrive());
		
    	//Finish
    	//Turn
    	
    	
    	
    	
    	
    	
    	
    	
    	
    }

    protected void initialize() {
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return false;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
