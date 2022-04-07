package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class Positionthree extends SequentialCommandGroup {
  public Positionthree() {
    addCommands(  //this is the one of our autons
                  new AutoPneuDeploy(),
                  new WaitCommand(0.5),
                  new AutoIntakeOn(),
                  new WaitCommand(0.5),
                  new AutoShoot(),
                  new WaitCommand(0.75),
                  new AutoShootEnd(),
                  new AutoForward(),
                  new WaitCommand(3),
                  new AutoReverse(),
                  new WaitCommand(3),
                  new AutoMoveEnd(),
                  new AutoShoot(),
                  new WaitCommand(.75),
                  new AutoShootEnd(),
                  new AutoIntakeOff(),
                  new AutoForward(),
                  new WaitCommand(2.5),
                  new Turnleft(),
                  new WaitCommand(0.6),
                  new AutoMoveEnd());
    addCommands();
  }
}
