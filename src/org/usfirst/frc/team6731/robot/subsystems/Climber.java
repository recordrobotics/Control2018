package org.usfirst.frc.team6731.robot.subsystems;

import org.usfirst.frc.team6731.robot.RobotMap;
import org.usfirst.frc.team6731.robot.commands.ClimbSlowly;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Climber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.
	
	private static Talon motor = new Talon(RobotMap.climbPort);

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new ClimbSlowly());
    }
    
    public void set(double v) {
    	motor.set(v);
    }
}

