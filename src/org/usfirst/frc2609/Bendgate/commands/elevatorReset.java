package org.usfirst.frc2609.Bendgate.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2609.Bendgate.Robot;

public class  elevatorReset extends Command {

    public elevatorReset() {
        requires(Robot.elevatorDrive);
    }

    protected void initialize() {	
    }

    protected void execute() {
    	Robot.elevatorDrive.disable();
    	Robot.elevatorDrive.elevatorReset();
    }

    protected boolean isFinished() {
        return true;
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
