package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class IntakeCommand extends CommandBase {
  public IntakeCommand() {
    addRequirements(Robot.intake);
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    //gets gamepad joysticks values
    double Xleftjoy = Robot.m_robotContainer.GetGamepadRawRightAxis(Constants.X_LEFT_JOYSTICK_ID);
    double Xrightjoy = Robot.m_robotContainer.GetGamepadRawLeftAxis(Constants.X_RIGHT_JOYSTICK_ID);
    //sets intake speeds
    Robot.intake.settransitionmotor(Xleftjoy*Constants.TRANSITION_SPEED_MODIFIER);
    Robot.intake.setintakemotor(Xrightjoy*Constants.INTAKE_SPEED_MODIFIER);
    Robot.intake.IntakePneumatics();
    Robot.intake.setneomotor(Xleftjoy);
  }

  @Override
  public void end(boolean interrupted) {
  Robot.intake.setintakemotor(Constants.MOTOR_OFF);
  Robot.intake.settransitionmotor(Constants.MOTOR_OFF);
  }
  @Override
  public boolean isFinished() {
    return false;
  }
}