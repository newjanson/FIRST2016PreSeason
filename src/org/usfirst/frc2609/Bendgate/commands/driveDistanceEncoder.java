package org.usfirst.frc2609.Bendgate.commands;

import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2609.Bendgate.Robot;

public class  driveDistanceEncoder extends Command {
	private double driveDistanceSetpoint;
	private double drivePower;
	
    public driveDistanceEncoder(double driveDistanceSetpoint,double drivePower) {
        requires(Robot.robotDrive);
        this.driveDistanceSetpoint = driveDistanceSetpoint;
        this.drivePower = drivePower;
    }

    protected void initialize() {
    	Robot.robotDrive.setOutputRange(-drivePower, drivePower);
        Robot.robotDrive.enable();
        Robot.robotDrive.setSetpoint(driveDistanceSetpoint);
    }

    protected void execute() {
    }

    protected boolean isFinished() {
        return Robot.robotDrive.onTarget();
    }

    protected void end() {
    	Robot.robotDrive.disable();
    	Robot.robotDrive.stopDrive();
    }

    protected void interrupted() {
    }
}
