package org.usfirst.frc2609.Bendgate.commands;
import org.usfirst.frc2609.Bendgate.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class  closeBottomGripper extends Command {

    public closeBottomGripper() {
        requires(Robot.bottomGripper);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.bottomGripper.close();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

