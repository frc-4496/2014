/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/
package edu.wpi.first.wpilibj.templates;


import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.RobotDrive;
import edu.wpi.first.wpilibj.Victor;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class RobotMain extends IterativeRobot {
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    
    Joystick mainStick = new Joystick(1); //setup main joystick to input 1
    
    Victor leftDrive = new Victor(1); //left motor setup to pinout 1
    Victor rightDrive = new Victor(2); //right motor setup to pinout 2
    
    RobotDrive mainDrive = new RobotDrive(leftDrive, rightDrive); //assign leftDrive and rightDrive to mainDrive
    
    int counter;
    
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
        mainDrive.arcadeDrive(mainStick); //assign mainDrive to the arcade type and assign to mainStick
        System.out.println(mainDrive.isAlive());
        System.out.println(mainDrive.isSafetyEnabled());
        System.out.println(mainDrive.getExpiration());
        System.out.println(leftDrive.getSpeed() + " LEFT SPEED | " + rightDrive.getSpeed() + " RIGHT SPEED");
        System.out.println(leftDrive.getPosition() + " LEFT POS | " + rightDrive.getPosition() + " RIGHT POS");
        System.out.println(mainStick.getX() + " X, " + mainStick.getY() + " Y");
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() {
    
    }
    
}
