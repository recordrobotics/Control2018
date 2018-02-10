package org.usfirst.frc.team6731.robot.commands;

import org.usfirst.frc.team6731.robot.OI;
import org.usfirst.frc.team6731.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveJoystick extends Command {

    public driveJoystick() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    	Joystick joystick = OI.get_joystick();
		double x_value = joystick.getX();
		double y_value = joystick.getY();
		Drivetrain.driveCheesy(y_value, x_value);	
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
