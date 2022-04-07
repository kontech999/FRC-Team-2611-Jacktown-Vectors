package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class AutoShootEnd extends CommandBase {
  //this ends our shooter in auton
  public AutoShootEnd() {
    addRequirements(Robot.shooter);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    Robot.shooter.setfullsendmotor(Constants.MOTOR_OFF);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}