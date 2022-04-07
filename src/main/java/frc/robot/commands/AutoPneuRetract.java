package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Robot;

public class AutoPneuRetract extends CommandBase {
  //this command retracts the intake pneumatics
  public AutoPneuRetract() {
    addRequirements(Robot.intake);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    Robot.intake.AutoPneuDeployReverseMethod();
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}