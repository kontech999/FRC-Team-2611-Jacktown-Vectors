package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Motordrive extends CommandBase {
  public Motordrive() {
    addRequirements(Robot.drivetrain);
  }
 
  @Override
  public void initialize() {}

  @Override
  public void execute(){
    //gets our joystick values
    double leftjoyY = Robot.m_robotContainer.GetleftjoyRawAxis(Constants.LEFT_JOYSTICK_YID);
    double RightjoyY = Robot.m_robotContainer.GetRightjoyRawAxis(Constants.RIGHT_JOYSTICK_YID);

    //sets speed to an exponential
    Robot.drivetrain.setrightmotor((Math.abs(RightjoyY))*RightjoyY);
    Robot.drivetrain.setleftmotor((Math.abs(leftjoyY))*leftjoyY);
  }
  
  @Override
  public void end(boolean interrupted) {
    Robot.drivetrain.setleftmotor(Constants.MOTOR_OFF);
    Robot.drivetrain.setrightmotor(Constants.MOTOR_OFF);
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}