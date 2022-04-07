package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class AutoIntakeOff extends CommandBase {
  //this command turns off flywheel and intake
  public AutoIntakeOff() {
    addRequirements(Robot.intake);
  }

  @Override
  public void initialize() {}
  @Override
  public void execute() {
    Robot.intake.settransitionmotor(Constants.MOTOR_OFF);
    Robot.intake.setintakemotor(Constants.MOTOR_OFF);
    Robot.shooter.setflywheelmotor(Constants.MOTOR_OFF);
  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}