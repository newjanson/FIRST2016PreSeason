package org.usfirst.frc2609.Bendgate.commands;
import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.command.Command;
import org.usfirst.frc2609.Bendgate.Robot;
import org.usfirst.frc2609.Bendgate.RobotMap;

public class  elevatorPoint1 extends Command {
    CANTalon cANTalonLeft = RobotMap.canTalonEL;
	private String setElevator;
    public elevatorPoint1(String setElevator) {
    	this.setElevator = setElevator;
        requires(Robot.elevatorDrive);
    }

    protected void initialize() {
    	Robot.elevatorDrive.enable();
    	Robot.elevatorDrive.setOutputRange(1, 1);
    	if (setElevator=="position1"){
    		//Robot.elevatorDrive.setSetpoint(0);
    		Robot.elevatorDrive.talonDrive(0);
    	}
    	else if (setElevator=="position2"){
    		//Robot.elevatorDrive.setSetpoint(780);
    		Robot.elevatorDrive.talonDrive(780*4);
    	}
    	else if (setElevator=="position3"){
    		//Robot.elevatorDrive.setSetpoint(2000);
    		Robot.elevatorDrive.talonDrive(2000*4);
    	}
    	else if (setElevator=="position4"){
    		//Robot.elevatorDrive.setSetpoint(6666);
    		Robot.elevatorDrive.talonDrive(6666*4);
    	}
    	else if (setElevator=="position5"){
    		//Robot.elevatorDrive.setSetpoint(1800);
    		Robot.elevatorDrive.talonDrive(1800*4);
    	}
    	else{
    		//Robot.elevatorDrive.setSetpoint(0);
    		Robot.elevatorDrive.talonDrive(0);
    	}
    }

    protected void execute() {
    	
    }

    protected boolean isFinished() {
    	if(Robot.elevatorDrive.getPosition() == (cANTalonLeft.getSetpoint())){
    		return true;
    	}
    	else if(Robot.elevatorDrive.getPosition() > (cANTalonLeft.getSetpoint()-20)){
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
