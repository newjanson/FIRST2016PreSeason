package org.usfirst.frc2609.Bendgate.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2609.Bendgate.Robot;

/**
*
*/
public class rollerStop extends Command {

   public rollerStop() {
   	requires(Robot.rollerDrive);
   }

   protected void initialize() {
   }

   protected void execute() {
   	Robot.rollerDrive.rollStop();
   }

   protected boolean isFinished() {
       return true;
   }

   protected void end() {
   }

   protected void interrupted() {
   }
}
