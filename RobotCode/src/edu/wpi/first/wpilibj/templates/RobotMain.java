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
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.Solenoid;

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
    //Joystick drive2 = new Joystick(2); //leftover for tank drive if needed
    
    //setup main drive object and point to victors
    RobotDrive mainDrive = new RobotDrive(leftDrive, rightDrive);
    
    //setup compressor
    Compressor mainComp = new Compressor(1, 1);
    
    //setup solenoids
    Solenoid solenoidFire = new Solenoid(2); //solenoid for firing system
    Solenoid solenoidPickup = new Solenoid(3); //solenoid for pickup system
    
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

        //saved tankDrive for future reference
        //tankDrive function is called, and assigned joystick inputs
        //mainDrive.tankDrive(drive1.getY(), drive2.getY());
         
        //arcadeDrive function is called, and assigned a joystick input
        mainDrive.arcadeDrive(drive1);
        
        //turn compressor on if trigger is pulled
        if(drive1.getTrigger() == true) {
            mainComp.start();
        }
        
        //turn compressor off if trigger is pulled
        if(drive1.getTrigger() == false) {
            mainComp.stop();
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        
    }
    
}
