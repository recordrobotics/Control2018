package org.usfirst.frc.team6731.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc.team6731.robot.OI;
import org.usfirst.frc.team6731.robot.RobotMap;
import org.usfirst.frc.team6731.robot.commands.driveJoystick;

import edu.wpi.first.wpilibj.Spark;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Joystick.AxisType;


/**
 *
 */
public class Drivetrain extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static Spark left_motor1 = new Spark(RobotMap.motor1Port);
	private static Spark left_motor2 = new Spark(RobotMap.motor2Port);
	private static Spark right_motor1 = new Spark(RobotMap.motor3Port);
	private static Spark right_motor2 = new Spark(RobotMap.motor4Port);
	
	public static void drive(double left, double right)
	{
		left_motor1.set(-left);
		left_motor2.set(-left);
		right_motor1.set(right);
		right_motor2.set(right);
		
		SmartDashboard.putNumber("Left", left);
		SmartDashboard.putNumber("Right", right);
		
		System.out.println("Left: " + left + "  Right: " + right);
	}
	
	public static void stop()
	{
		left_motor1.set(0);
		left_motor2.set(0);
		right_motor1.set(0);
		right_motor2.set(0);
	}
	
	public static void driveCheesy(double throttle, double turn, double sensitivity)
	{
		double left, right;

		throttle = throttle * sensitivity;
		turn = turn * sensitivity;
		
		left = throttle-turn;
		right = throttle+turn;
		
		/*if(Math.abs(left) > 1)
		{
			right += right/Math.abs(right) * (Math.abs(left)-1);
			left = left/Math.abs(left) * 1;
		}
		if(Math.abs(right) > 1)
		{
			left += left/Math.abs(left) * (Math.abs(right)-1);
			right = right/Math.abs(right) * 1;
		}*/
		
		drive(left, right);
	}
	
	
		
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new driveJoystick());
    }
}

