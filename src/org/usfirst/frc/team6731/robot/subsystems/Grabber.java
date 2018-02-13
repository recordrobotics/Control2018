package org.usfirst.frc.team6731.robot.subsystems;

import org.usfirst.frc.team6731.robot.RobotMap;
import org.usfirst.frc.team6731.robot.commands.TestSolenoid;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	private static DoubleSolenoid solenoid = new DoubleSolenoid(RobotMap.grabberPort1, RobotMap.grabberPort2);
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        setDefaultCommand(new TestSolenoid());
    }
    
    public void set(DoubleSolenoid.Value v) {
    	solenoid.set(v);
    }
}

