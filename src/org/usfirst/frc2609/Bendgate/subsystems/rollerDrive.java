package org.usfirst.frc2609.Bendgate.subsystems;
import org.usfirst.frc2609.Bendgate.RobotMap;
import org.usfirst.frc2609.Bendgate.commands.loadStackTote;
import org.usfirst.frc2609.Bendgate.commands.timerDelay;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class rollerDrive extends Subsystem {
    SpeedController rollerLeft = RobotMap.rollerLeft;
    SpeedController rollerRight = RobotMap.rollerRight;
    DigitalInput toteSenseR = RobotMap.toteSenseR;
    DigitalInput toteSenseL = RobotMap.toteSenseL;
    double rotateSpeed = .5;
    double rollSpeed = .5;
    public void rollRight(){
    	rollerLeft.set(rotateSpeed);
    	rollerRight.set(rotateSpeed);
    }
    public void rollLeft(){
    	rollerLeft.set(-rotateSpeed);
    	rollerRight.set(-rotateSpeed);
    }
	public void rollIn(){
		rollerLeft.set(rollSpeed);
		rollerRight.set(-rollSpeed);
    	//Timer.delay(1);
    	//rollerLeft.set(0);
		//rollerRight.set(0);
		//Timer.delay(0.01);
    	//Robot.rollerDrive.rollStop();
    	//Timer.delay(0.01);
	}
	public void rollStop(){
		rollerLeft.set(0);
		rollerRight.set(0);
	}
	public void rollOut(){
		rollerLeft.set(-rollSpeed);
		rollerRight.set(rollSpeed);
	}
    public void readSensor(){

    	SmartDashboard.putBoolean("toteSenseR", toteSenseR.get());
    	SmartDashboard.putBoolean("toteSenseL", toteSenseL.get());
        
    }

    public void initDefaultCommand() {
    }
    
}