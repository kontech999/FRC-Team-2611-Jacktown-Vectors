// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.ClimberCommand;

public class Climber extends SubsystemBase {
  // Climber motors
  private CANSparkMax sparkMax = new CANSparkMax(Constants.CLIMBER_MOTOR_ID, MotorType.kBrushless);
  private CANSparkMax sparkMax2 = new CANSparkMax(Constants.CLIMBER_MOTORTWO_ID, MotorType.kBrushless);
  /** Creates a new Climber. */
  public Climber() {}

  @Override
  public void periodic() {
    setDefaultCommand(new ClimberCommand());
    // This method will be called once per scheduler run
  }
  public void setclimbermotor(double speed) {
    // this method controls our climber
    sparkMax.set(speed);
    sparkMax2.set(-speed);
  }
}
