// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class AutoMoveForwardWithEncoder extends CommandBase {
  // this command moves forward a certain encoder count
  // it is not currently used in our auton
  /** Creates a new AutoMoveForwardWithEncoder. */
  double distance1;
  public AutoMoveForwardWithEncoder(double distancetotravel) {
    addRequirements(Robot.drivetrain);
    distance1 = distancetotravel;
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    Robot.drivetrain.resetencodervalues();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    Robot.drivetrain.setleftmotor(Constants.AUTO_SPEED);
    Robot.drivetrain.setrightmotor(Constants.AUTO_SPEED);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    Robot.drivetrain.setrightmotor(Constants.MOTOR_OFF);
    Robot.drivetrain.setleftmotor(Constants.MOTOR_OFF);
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return Robot.drivetrain.getencoderleft1value() == distance1;
  }
}
