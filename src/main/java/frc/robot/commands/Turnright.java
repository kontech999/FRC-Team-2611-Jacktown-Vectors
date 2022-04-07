package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Turnright extends CommandBase {
  // this Auto command turns the bot right
  public Turnright() {
    addRequirements(Robot.drivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    Robot.drivetrain.setleftmotor(Constants.AUTO_SPEED);
    Robot.drivetrain.setrightmotor(-Constants.AUTO_SPEED);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}