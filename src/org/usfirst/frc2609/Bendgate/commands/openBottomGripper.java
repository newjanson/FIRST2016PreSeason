package org.usfirst.frc2609.Bendgate.commands;
import org.usfirst.frc2609.Bendgate.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class  openBottomGripper extends Command {

    public openBottomGripper() {
        requires(Robot.bottomGripper);
    }
    
    protected void initialize() {
    }

    protected void execute() {
    	Robot.bottomGripper.open();
    }
    
    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
