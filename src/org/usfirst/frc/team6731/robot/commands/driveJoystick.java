package org.usfirst.frc.team6731.robot.commands;

import org.usfirst.frc.team6731.robot.OI;
import org.usfirst.frc.team6731.robot.Robot;
import org.usfirst.frc.team6731.robot.RobotMap;
import org.usfirst.frc.team6731.robot.subsystems.Drivetrain;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class driveJoystick extends Command {

    public driveJoystick() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.drivetrain);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() 
    {
    
    	Joystick joystick = OI.get_joystick();
		double x_value = joystick.getRawAxis(RobotMap.forwardAxis);
		double y_value = joystick.getRawAxis(RobotMap.turnAxis);
		double sens = joystick.getRawAxis(RobotMap.sensAxis);
		Drivetrain.driveCheesy(y_value, x_value, 0.5);	
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
