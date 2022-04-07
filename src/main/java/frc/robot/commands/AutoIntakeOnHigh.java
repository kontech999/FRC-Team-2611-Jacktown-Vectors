// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class AutoIntakeOnHigh extends CommandBase {
  //this command turns on our intake motors and sets the flywheel to high goal
  /** Creates a new AutoIntakeOnHigh. */
  public AutoIntakeOnHigh() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.intake);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.shooter.setflywheelmotor(Constants.SHOOT_HIGH);

    /*if (lowhigh = true) {
      Robot.shooter.setflywheelmotor(Constants.SHOOT_HIGH);
    }
    else {
      Robot.shooter.setflywheelmotor(Constants.SHOOT_LOW);
    }*/
    Robot.intake.settransitionmotor(Constants.TRANSITION_SPEED_MODIFIER);
    Robot.intake.setintakemotor(Constants.INTAKE_SPEED_MODIFIER);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return true;
  }
}
