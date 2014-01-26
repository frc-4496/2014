/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Joystick;

public class RobotMain extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    //setup left and right drives and assign to pinouts
    Victor leftDrive = new Victor(1);
    Victor rightDrive = new Victor(2);
    
    //setup controllers
    Joystick drive1 = new Joystick(1);
    Joystick drive2 = new Joystick(2);
    
    //setup main drive object and point to victors
    RobotDrive mainDrive = new RobotDrive(leftDrive, rightDrive);
    
    public void robotInit() {
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
        //tankDrive function is called, and assigned joystick inputs
        mainDrive.tankDrive(drive1.getY(), drive2.getY());
        
        //arcade drive code commented out, for future reference
        //mainDrive.arcadeDrive(drive1);
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        
    }
    
}
