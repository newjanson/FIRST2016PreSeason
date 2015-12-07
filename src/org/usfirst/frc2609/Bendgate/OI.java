package org.usfirst.frc2609.Bendgate;
import org.usfirst.frc2609.Bendgate.RobotMap;
import org.usfirst.frc2609.Bendgate.commands.*;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);
    
    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.
    
    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:
    
    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());
    
    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());
    
    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());
	DigitalInput toteSenseR = RobotMap.toteSenseR;
    DigitalInput toteSenseL = RobotMap.toteSenseL;
    public static Joystick driverPad;
    public static Joystick operatorPad;
	Encoder quadratureEncoder1 = RobotMap.encoderElevator;
    public JoystickButton openBottomGripper;
    public JoystickButton closeBottomGripper;
    public JoystickButton doRollersIn;
    public JoystickButton doRollersOut;
    public JoystickButton doRollersLeft;
    public JoystickButton doRollersRight;
    public JoystickButton doloadStackTote;

    public OI() {
        operatorPad = new Joystick(1);
        driverPad = new Joystick(0);
        
        doRollersOut = new JoystickButton(driverPad, 5);
        doRollersOut.whileHeld(new rollerOut());
        doRollersIn = new JoystickButton(driverPad, 6);
        doloadStackTote = new JoystickButton(driverPad, 4);
        doRollersIn.whenPressed(new rollerIn());
        doloadStackTote.whenPressed(new loadStackTote());
        doRollersIn.whenReleased(new rollerStop());
        doRollersOut.whenReleased(new rollerStop());
        doRollersRight = new JoystickButton(driverPad, 1);
        doRollersRight.whileHeld(new rollerRight());
        doRollersRight.whenReleased(new rollerStop());
        doRollersLeft = new JoystickButton(driverPad, 3);
        doRollersLeft.whileHeld(new rollerLeft());
        doRollersLeft.whenReleased(new rollerStop());

        openBottomGripper = new JoystickButton(driverPad, 7);        
        closeBottomGripper = new JoystickButton(driverPad, 8);
        closeBottomGripper.whileHeld(new closeBottomGripper());
        openBottomGripper.whileHeld(new openBottomGripper());

        JoystickButton openTopGripper = new JoystickButton(operatorPad, 5);
        JoystickButton closeTopGripper = new JoystickButton(operatorPad, 6);
        JoystickButton elevatorPoint1 = new JoystickButton(operatorPad, 1);
        JoystickButton elevatorPoint2 = new JoystickButton(operatorPad, 2);
        JoystickButton elevatorPoint3 = new JoystickButton(operatorPad, 3);
        JoystickButton elevatorPoint4 = new JoystickButton(operatorPad, 4);
        JoystickButton elevatorReset = new JoystickButton(operatorPad, 10);
        openTopGripper.whileHeld(new openTopGripper());
        closeTopGripper.whileHeld(new closeTopGripper());
        elevatorReset.whileHeld(new elevatorReset());
        elevatorPoint1.whileHeld(new elevatorPoint1("position1"));
    	elevatorPoint2.whileHeld(new elevatorPoint1("position2"));
		elevatorPoint3.whileHeld(new elevatorPoint1("position3"));
		elevatorPoint4.whileHeld(new elevatorPoint1("position4"));
		
		
		//SmartDashboard.putNumber("getRawAxis(5)", Math.abs(OI.operatorPad.getRawAxis(5)));
		// SmartDashboard Buttons
		/*
        SmartDashboard.putData("Autonomous Command", new autonomousCommand());
        SmartDashboard.putData("openTopGripper", new openTopGripper());
        SmartDashboard.putData("releaseTopGripper", new releaseTopGripper());
        SmartDashboard.putData("closeTopGripper", new closeTopGripper());
        SmartDashboard.putData("openBottomGripper", new openBottomGripper());
        SmartDashboard.putData("releaseBottomGripper", new releaseBottomGripper());
        SmartDashboard.putData("closeBottomGripper", new closeBottomGripper());
        SmartDashboard.putData("rollerIn", new rollerIn());
        SmartDashboard.putData("rollerStop", new rollerStop());
        SmartDashboard.putData("rollerOut", new rollerOut());
        SmartDashboard.putData("driveAngleTurn", new driveAngleTurn(0));
        //SmartDashboard.putData("driveDistanceEncoder", new driveDistanceEncoder());
    */
    }
    public Command GetCommands(){
		return null;
    }
    
    public Joystick getdriverPad() {
        return driverPad;
    }

    public Joystick getoperatorPad() {
        return operatorPad;
    }

}

