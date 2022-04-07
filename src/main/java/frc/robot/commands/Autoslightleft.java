package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class Autoslightleft extends CommandBase {
  // this command moves the bot forward ad to the left.
  public Autoslightleft() {
    addRequirements(Robot.drivetrain);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    Robot.drivetrain.setleftmotor(Constants.AUTO_SPEED*1.25);
    Robot.drivetrain.setrightmotor(Constants.AUTO_SPEED*1.1);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}