package org.usfirst.frc2609.BendGate.subsystems;
import org.usfirst.frc2609.BendGate.RobotMap;
import org.usfirst.frc2609.BendGate.commands.*;

import edu.wpi.first.wpilibj.CANTalon;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSource.PIDSourceParameter;
import edu.wpi.first.wpilibj.can.*;

import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.RobotDrive;

/**
 *
 */
public class Movement extends PIDSubsystem {
	Encoder drivequadratureEncoderLeft = RobotMap.drivequadratureEncoderLeft;
	Encoder drivequadratureEncoderRight = RobotMap.drivequadratureEncoderRight;
	RobotDrive RobotDrive4 = RobotMap.RobotDrive4;
	CANTalon driveCANTalonLF = RobotMap.driveCANTalonLF;
    CANTalon driveCANTalonLR = RobotMap.driveCANTalonLR;
    CANTalon driveCANTalonRF = RobotMap.driveCANTalonRF;
    CANTalon driveCANTalonRR = RobotMap.driveCANTalonRR;
	
    // Initialize your subsystem here
    public Movement() {
    	super("Movement", .005, 0.0, 0.0);
        setAbsoluteTolerance(20);
        getPIDController().setContinuous(false);
        //LiveWindow.addActuator("Movement", "PIDSubsystem Controller", getPIDController());
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }
    
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
    
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;
    	return drivequadratureEncoderLeft.get();
    }
    
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);
    	driveCANTalonLF.pidWrite(output/5);
    	driveCANTalonLR.pidWrite(output/5);
    	driveCANTalonRF.pidWrite(-output/5);
    	driveCANTalonRR.pidWrite(-output/5);
    }
}
