package org.usfirst.frc.team6731.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;

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
	
	
	private static Spark motor1 = new Spark(RobotMap.motor1Port);
	private static Spark motor2 = new Spark(RobotMap.motor2Port);
	private static Spark motor3 = new Spark(RobotMap.motor3Port);
	private static Spark motor4 = new Spark(RobotMap.motor4Port);
	
	public static void drive(double left, double right)
	{
		motor1.set(left);
		motor2.set(-left);
		motor3.set(right);
		motor4.set(-right);
	}
	
	public static void stop()
	{
		motor1.set(0);
		motor2.set(0);
		motor3.set(0);
		motor4.set(0);
	}
	
	public static double change_sensitivity(double num, double value)
	{
		return num*value;
	}
	
	
	
	
	public static void driveCheesy(double throttle, double turn)
	{
		double left, right;

		double sensitivity = 1;
		throttle = change_sensitivity(throttle, sensitivity);
		turn = change_sensitivity(turn, sensitivity);
		
		left = throttle-turn;
		right = throttle+turn;
		
		if(Math.abs(left) > 1)
		{
			right += right/Math.abs(right) * (Math.abs(left)-1);
			left = left/Math.abs(left) * 1;
		}
		if(Math.abs(right) > 1)
		{
			left += left/Math.abs(left) * (Math.abs(right)-1);
			right = right/Math.abs(right) * 1;
		}
		
		drive(left, right);
	}
	
	
		
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    	setDefaultCommand(new driveJoystick());
    }
}

