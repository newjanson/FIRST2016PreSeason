package org.usfirst.frc2609.Bendgate.commands;
import org.usfirst.frc2609.Bendgate.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class  closeTopGripper extends Command {

    public closeTopGripper() {
        requires(Robot.topGripper);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.topGripper.close();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
