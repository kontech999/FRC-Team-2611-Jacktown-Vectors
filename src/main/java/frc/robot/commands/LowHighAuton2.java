// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class LowHighAuton2 extends SequentialCommandGroup {
  /** Creates a new LowHighAuton2. */
  public LowHighAuton2() {
    // Add your commands in the addCommands() call, e.g.
    addCommands( 
    //this is the one of our autons
    new AutoPneuDeploy(),
    new WaitCommand(0.5),
    new AutoIntakeOn(),
    new WaitCommand(0.5),
    new AutoShoot(),
    new WaitCommand(0.75),
    new AutoShootEnd(),
    new Autoslightleft(),
    new WaitCommand(2.5),
    new AutoIntakeOnHigh(),
    new AutoMoveForwardWithEncoder(50),
    new AutoMoveEnd(),
    new AutoShoot(),
    new WaitCommand(0.75),
    new AutoShootEnd(),
    new AutoIntakeOff(),
    new AutoMoveEnd(),
    new AutoIntakeOn());
  }
}
