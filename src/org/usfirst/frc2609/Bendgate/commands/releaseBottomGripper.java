package org.usfirst.frc2609.Bendgate.commands;
import org.usfirst.frc2609.Bendgate.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class  releaseBottomGripper extends Command {

    public releaseBottomGripper() {
        requires(Robot.bottomGripper);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.bottomGripper.release();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

