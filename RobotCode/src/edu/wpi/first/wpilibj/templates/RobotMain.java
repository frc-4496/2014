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

public class RobotMain extends IterativeRobot {
    
    //setup left and right drives and assign to pinouts
    Victor leftDrive = new Victor(2);
    Victor rightDrive = new Victor(1);
    
    //setup firing mechanism motor
    Victor releaseMotor = new Victor(3);
    
    //setup controllers
    Joystick drive1 = new Joystick(1);
    
    //setup main drive object and point to victors
    RobotDrive mainDrive = new RobotDrive(leftDrive, rightDrive);
    
    //setup compressor
    Compressor mainComp = new Compressor(1, 1); //main compressor for pneumatics
    
    //setup solenoids]
    Solenoid solenoidFire = new Solenoid(2); //solenoid for firing system
    Solenoid solenoidPickup = new Solenoid(3); //solenoid for pickup system
    
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() {
        
    }

    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() {
        //fire the solenoid
        solenoidFire.set(true);
        Timer.delay(0.5);
        solenoidFire.set(false);
        
        //drive the robut forward
        mainDrive.arcadeDrive(1, 0);
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() {
         
        //arcadeDrive function is called, and assigned a joystick input
        mainDrive.arcadeDrive(drive1);
        
        //turn the compresor on if needed
        if(mainComp.getPressureSwitchValue() == false) {
            mainComp.start();
        } else if(mainComp.getPressureSwitchValue() == true) {
            mainComp.stop();
        }
        
        //write the code for the firing solenoid
        if(drive1.getTrigger() == true) {
            solenoidFire.set(true);
            Timer.delay(0.25);
        } else if (drive1.getTrigger() == false) {
            solenoidFire.set(false);
        }
        
        //write the code for the lifting solenoid
        if(drive1.getButton(Joystick.ButtonType.kNumButton) == true) {
            solenoidPickup.set(false);
            Timer.delay(0.5);
        } else if (drive1.getButton(Joystick.ButtonType.kNumButton) == false){
            solenoidPickup.set(true);   
        }
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
        
    }   
}