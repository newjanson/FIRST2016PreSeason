package org.usfirst.frc2609.Bendgate.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2609.Bendgate.Robot;

public class  elevatorDisable extends Command {

    public elevatorDisable() {
        requires(Robot.elevatorDrive);
    }

    protected void initialize() {
        
    }

    protected void execute() {
    	Robot.elevatorDrive.talonDisable();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
