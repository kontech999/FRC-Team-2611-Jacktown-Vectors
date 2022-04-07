// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class twohighpos3 extends SequentialCommandGroup {
  /** Creates a new HighAutonPos3. */
  public twohighpos3() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
                  //this is the one of our autons
                  new AutoPneuDeploy(),
                  new WaitCommand(0.5),
                  new AutoForwardSlow(),
                  new AutoIntakeOnHigh(),
                  new AutoTransitionMotorOff(),
                  new WaitCommand(6.1),
                  new AutoMoveEnd(),
                  new WaitCommand(.5),
                  new AutoTransitionMotorOn(),
                  new AutoShoot(),
                  new WaitCommand(0.1),
                  new AutoShootEnd(),
                  new WaitCommand(0.5),
                  new AutoShoot(),
                  new WaitCommand(0.5),
                  new AutoIntakeOff(),
                  new Turnleft(),
                  new WaitCommand(0.6),
                  new AutoMoveEnd());
  }
}
