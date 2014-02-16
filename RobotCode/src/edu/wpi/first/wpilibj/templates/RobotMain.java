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
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.Servo;

public class RobotMain extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    //setup left and right drives and assign to pinouts
    Victor leftDrive = new Victor(1);
    Victor rightDrive = new Victor(2);
    
    //lets set up the servo
    Servo releaseServo = new Servo(1);
    
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
        releaseServo.setAngle(180);
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        //fire the solenoid
        solenoidFire.set(true);
        Timer.delay(2);
        releaseServo.setAngle(120);
        Timer.delay(2);
        solenoidFire.set(false);
        Timer.delay(2);
        releaseServo.setAngle(0);
        
        //drive the robut forward
        mainDrive.arcadeDrive(1.0, 0.0);
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
        
        //turn the compresor on if needed
        if(mainComp.getPressureSwitchValue() == false) {
            mainComp.start();
        }
        
        //stop the compressor when needed
        if(mainComp.getPressureSwitchValue() == true) {
            mainComp.stop();
        }
        
        //write the code for the firing solenoid
        if(drive1.getTrigger() == true) {
            solenoidFire.set(true);
            Timer.delay(2);
            releaseServo.setAngle(0);
            Timer.delay(2);
            solenoidFire.set(false);
            Timer.delay(2);
            releaseServo.setAngle(0);
        }
        
        //write the code for the lifting solenoid
        if(drive1.getRawButton(1) == true) {
            solenoidPickup.set(true);
        }
        
        if(drive1.getRawButton(1) == false) {
            solenoidPickup.set(false);
        }
        
        
        //turn compressor on if trigger is pulled
        /*if(drive1.getTrigger() == true) {
            mainComp.start();
        }
        
        //turn compressor off if trigger is pulled
        if(drive1.getTrigger() == false) {
            mainComp.stop();
        }
        */
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        
    }   
}
