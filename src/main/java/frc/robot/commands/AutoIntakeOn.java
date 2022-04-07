package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class AutoIntakeOn extends CommandBase {
    //this command turns on our intake motors and sets the flywheel to low goal

  public AutoIntakeOn() {
    addRequirements(Robot.intake);
    
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
    Robot.shooter.setflywheelmotor(Constants.SHOOT_LOW);

    /*if (lowhigh = true) {
      Robot.shooter.setflywheelmotor(Constants.SHOOT_HIGH);
    }
    else {
      Robot.shooter.setflywheelmotor(Constants.SHOOT_LOW);
    }*/
    Robot.intake.settransitionmotor(Constants.TRANSITION_SPEED_MODIFIER);
    Robot.intake.setintakemotor(Constants.INTAKE_SPEED_MODIFIER);

  }

  @Override
  public void end(boolean interrupted) {}

  @Override
  public boolean isFinished() {
    return true;
  }
}