// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

// NOTE:  Consider using this command inline, rather than writing a subclass.  For more
// information, see:
// https://docs.wpilib.org/en/stable/docs/software/commandbased/convenience-features.html
public class threehighpos2 extends SequentialCommandGroup {
  /** Creates a new HighAutonPos3. */
  public threehighpos2() {
    // Add your commands in the addCommands() call, e.g.
    // addCommands(new FooCommand(), new BarCommand());
    addCommands(
                  //this is the one of our autons
                  new AutoPneuDeploy(),
                  new WaitCommand(0.5),
                  new AutoForwardSlow(),
                  new AutoIntakeOnHigh(),
                  new AutoTransitionMotorOff(),
                  //new WaitCommand(1),
                 // new AutoTransitionMotorOn(),
                  new WaitCommand(7.25),
                 // new AutoTransitionMotorOff(),
                //  new WaitCommand(2.85),
                  new Turnleft(),
                  new WaitCommand(0.05),
                  new AutoMoveEnd(),
                  new WaitCommand(1),
                  new AutoTransitionMotorOn(),
                  new WaitCommand(.25),
                  new AutoShoot(),
                  new WaitCommand(0.09),
                  new AutoShootEnd(),
                  new WaitCommand(0.5),
                  new AutoShoot(),
                  new WaitCommand(0.5),
                  new AutoShootEnd(),
                  new WaitCommand(4.5),
                  new AutoShoot(),
                  new WaitCommand(0.5),
                  new AutoIntakeOff(),
                  new AutoMoveEnd());  
  }
}
