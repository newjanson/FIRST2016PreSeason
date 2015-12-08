package org.usfirst.frc2609.Bendgate.commands;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2609.Bendgate.Robot;
import org.usfirst.frc2609.Bendgate.subsystems.robotDrive;
import com.kauailabs.navx.frc.AHRS;

public class  driveAngleTurn extends Command {
	AHRS ahrs = robotDrive.ahrs;
	private double driveHeading;
    public driveAngleTurn(double driveHeading) {
    	this.driveHeading = driveHeading;
        requires(Robot.robotDrive);
    }

    protected void initialize() {
    	Robot.robotDrive.disable();
    	Robot.robotDrive.setOutputRange(-.5, .5);
    	Robot.robotDrive.robotDriveHeading = driveHeading;
        Robot.robotDrive.bendTurn();
    }

    protected void execute() {
    	Robot.robotDrive.bendTurn();
    }

    protected boolean isFinished() {
    	if (ahrs.getYaw()==driveHeading){
    		return true;
    	}
    	else{
    		return false;
    	}
    }

    protected void end() {
    }

    protected void interrupted() {
    }
}
