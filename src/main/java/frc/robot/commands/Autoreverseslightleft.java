package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Autoreverseslightleft extends CommandBase {
  //this command moves the robot backwards and to the left 
  public Autoreverseslightleft() {
    addRequirements(Robot.drivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    Robot.drivetrain.setrightmotor(-Constants.AUTO_SPEED*1.1);
    Robot.drivetrain.setleftmotor(-Constants.AUTO_SPEED*1.25);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}