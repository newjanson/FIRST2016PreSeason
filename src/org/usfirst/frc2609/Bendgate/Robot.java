package org.usfirst.frc2609.Bendgate;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import org.usfirst.frc2609.Bendgate.Robot;
import org.usfirst.frc2609.Bendgate.commands.*;
import org.usfirst.frc2609.Bendgate.subsystems.*;
 
public class Robot extends IterativeRobot {
	
    Command autonomousCommand;
    SendableChooser autoChooser;
    public static OI oi;
    public static robotDrive robotDrive;;
    public static elevatorDrive elevatorDrive;;
    public static bottomGripper bottomGripper;
    public static topGripper topGripper;
    public static rollerDrive rollerDrive;
	DigitalInput toteSenseR = RobotMap.toteSenseR;
    DigitalInput toteSenseL = RobotMap.toteSenseL;

    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
    RobotMap.init();
        robotDrive = new robotDrive();
        elevatorDrive = new elevatorDrive();
        bottomGripper = new bottomGripper();
        topGripper = new topGripper();
        rollerDrive = new rollerDrive();
        autoChooser = new SendableChooser();
        //do not comment out the following
        autoChooser.addDefault("Stop Drive", new stopDrive());
        autoChooser.addObject("Auto zone Drive Forward", new autoZone());
        autoChooser.addObject("Auto zone Drive Backward", new autoZoneBack());
        autoChooser.addObject("Bin Drop", new binDrop());
        SmartDashboard.putData("Auto chooser", autoChooser);
        
        // OI must be constructed after subsystems. If the OI creates Commands 
        //(which it very likely will), subsystems are not guaranteed to be 
        // constructed yet. Thus, their requires() statements may grab null 
        // pointers. Bad news. Don't move it.
        oi = new OI();

        // instantiate the command used for the autonomous period
        autonomousCommand = new autonomousCommand();
}

    /**
     * This function is called when the disabled button is hit.
     * You can use it to reset subsystems before shutting down.
     */
    public void disabledInit(){
    }

    public void disabledPeriodic() {
        Scheduler.getInstance().run();
    }

    public void autonomousInit() {
    	autonomousCommand = (Command) autoChooser.getSelected();
    	Robot.robotDrive.driveReset();
    	//ahrs.zeroYaw();
        if (autonomousCommand != null) autonomousCommand.start();
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        Scheduler.getInstance().run();
    }

    public void teleopInit() {
        // This makes sure that the autonomous stops running when
        // teleop starts running.
        if (autonomousCommand != null) autonomousCommand.cancel();
        Robot.robotDrive.setOutputRange(-1, 1); //Restore full range to robotDrive
        Robot.robotDrive.driveReset();//Reset wheel encoders
        Robot.robotDrive.disable();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        Scheduler.getInstance().run();
        Robot.robotDrive.bendDrive();
        Robot.elevatorDrive.elevatorStick();        
    }

    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        LiveWindow.run();
    }
}
