package org.usfirst.frc2609.Bendgate.subsystems;
import org.usfirst.frc2609.Bendgate.RobotMap;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class bottomGripper extends Subsystem {
    DoubleSolenoid doubleSolenoid1 = RobotMap.bottomGripperSolenoid;

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
    }
    
}
