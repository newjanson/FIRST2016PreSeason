package org.usfirst.frc2609.Bendgate.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2609.Bendgate.Robot;

public class  rollerOut extends Command {

    public rollerOut() {
        requires(Robot.rollerDrive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.rollerDrive.rollOut();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
