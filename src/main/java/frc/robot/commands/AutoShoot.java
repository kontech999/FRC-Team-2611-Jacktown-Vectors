package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class AutoShoot extends CommandBase {
  //this starts out shooter in auton
  public AutoShoot() {
    addRequirements(Robot.shooter);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    Robot.shooter.setfullsendmotor(Constants.FULLSEND_MOTOR_ON);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}