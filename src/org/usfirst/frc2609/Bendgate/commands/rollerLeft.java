package org.usfirst.frc2609.Bendgate.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2609.Bendgate.Robot;

public class  rollerLeft extends Command {

    public rollerLeft() {
        requires(Robot.rollerDrive);
    }

    protected void initialize() {
    }

    protected void execute() {
    	Robot.rollerDrive.rollLeft();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}

