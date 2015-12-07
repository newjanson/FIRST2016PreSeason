package org.usfirst.frc2609.Bendgate.commands;
import org.usfirst.frc2609.Bendgate.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class stopDrive extends Command {

    public stopDrive() {
        requires(Robot.robotDrive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.robotDrive.stopDrive();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
