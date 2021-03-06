package org.usfirst.frc.team6731.robot.commands;

import org.usfirst.frc.team6731.robot.Robot;

import org.usfirst.frc.team6731.robot.OI;
import org.usfirst.frc.team6731.robot.RobotMap;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class TestSolenoid extends Command {

    public TestSolenoid() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.grabber);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    	Joystick j = OI.get_joystick();
    	boolean open = j.getRawButton(RobotMap.solenoidTestButton);
   
    	Robot.grabber.set(open ? DoubleSolenoid.Value.kForward : DoubleSolenoid.Value.kReverse);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
