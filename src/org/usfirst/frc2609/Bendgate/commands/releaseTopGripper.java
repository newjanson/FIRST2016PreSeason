package org.usfirst.frc2609.Bendgate.commands;
import org.usfirst.frc2609.Bendgate.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class  releaseTopGripper extends Command {

    public releaseTopGripper() {
        requires(Robot.topGripper);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.topGripper.release();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
