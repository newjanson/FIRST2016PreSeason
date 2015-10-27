package org.usfirst.frc2609.Bendgate.subsystems;

import org.usfirst.frc2609.Bendgate.RobotMap;
import org.usfirst.frc2609.Bendgate.commands.*;
import edu.wpi.first.wpilibj.*;

import edu.wpi.first.wpilibj.command.Subsystem;

import org.usfirst.frc2609.Bendgate.OI;
import org.usfirst.frc2609.Bendgate.Robot;
import org.usfirst.frc2609.Bendgate.RobotMap;
import org.usfirst.frc2609.Bendgate.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Subsystem;

public class rollerDrive extends Subsystem {
    SpeedController rollerLeft = RobotMap.rollerLeft;
    SpeedController rollerRight = RobotMap.rollerRight;

    
	public void rollIn(){
		rollerLeft.set(.5);
		rollerRight.set(-.5);
	}
	public void rollStop(){
		rollerLeft.set(0);
		rollerRight.set(0);
	}
	public void rollOut(){
		rollerLeft.set(-.5);
		rollerRight.set(.5);
	}

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        //setDefaultCommand(new Robot.rollers.rollStop());

    }
    
}