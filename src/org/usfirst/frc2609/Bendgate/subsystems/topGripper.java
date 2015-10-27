package org.usfirst.frc2609.Bendgate.subsystems;
import org.usfirst.frc2609.Bendgate.RobotMap;
import org.usfirst.frc2609.Bendgate.commands.*;
import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;


public class topGripper extends Subsystem {
    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    DoubleSolenoid doubleSolenoid1 = RobotMap.topGripperSolenoid;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public void close() {
    	doubleSolenoid1.set(DoubleSolenoid.Value.kReverse);
	}
    public void open() {
    	doubleSolenoid1.set(DoubleSolenoid.Value.kForward);
	}
    public void release() {
    	doubleSolenoid1.set(DoubleSolenoid.Value.kOff);
	}

    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND
	
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
}