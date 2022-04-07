// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class fourballHighAuton extends SequentialCommandGroup {
  /** Creates a new fourballHighAuton. */
  public fourballHighAuton() {
    // Add your commands in the addCommands() call, e.g.
    addCommands(
      //this is the one of our autons
      // all the times add up the 14.35 seconds
                  new AutoPneuDeploy(),
                  new WaitCommand(0.5),
                  new AutoIntakeOnHigh(),
                  new AutoForward(),
                  new WaitCommand(3),
                  new AutoReverse(),
                  new WaitCommand(1),
                  new Turnright(),
                  new WaitCommand(.5),
                  new AutoForward(),
                  new WaitCommand(3.5),
                  new Turnleft(),
                  new WaitCommand(.75),
                  new AutoMoveEnd(),
                  new AutoShoot(),
                  new WaitCommand(0.1),
                  new AutoShootEnd(),
                  new WaitCommand(0.5),
                  new AutoShoot(),
                  new AutoShootEnd(),
                  new WaitCommand(0.5),
                  new AutoShoot(),
                  new WaitCommand(0.5),
                  new WaitCommand(3.5),
                  new AutoShootEnd(),
                  new AutoIntakeOff()





    );
    addCommands();
  }
}
