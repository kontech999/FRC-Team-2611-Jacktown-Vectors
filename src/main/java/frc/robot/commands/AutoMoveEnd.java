package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class AutoMoveEnd extends CommandBase {
  //this command ends any drivetrain movement
  public AutoMoveEnd() {
    addRequirements(Robot.drivetrain);
    }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    Robot.drivetrain.setrightmotor(Constants.MOTOR_OFF);
    Robot.drivetrain.setleftmotor(Constants.MOTOR_OFF);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}