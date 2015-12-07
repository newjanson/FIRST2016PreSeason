package org.usfirst.frc2609.Bendgate.subsystems;
import org.usfirst.frc2609.Bendgate.RobotMap;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;

public class rollerDrive extends Subsystem {
    SpeedController rollerLeft = RobotMap.rollerLeft;
    SpeedController rollerRight = RobotMap.rollerRight;

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
	}
	public void rollStop(){
		rollerLeft.set(0);
		rollerRight.set(0);
	}
	public void rollOut(){
		rollerLeft.set(-rollSpeed);
		rollerRight.set(rollSpeed);
	}

    public void initDefaultCommand() {
    }
    
}