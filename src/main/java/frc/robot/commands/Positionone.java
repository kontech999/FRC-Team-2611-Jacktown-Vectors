package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class Positionone extends SequentialCommandGroup {
  public Positionone() {
    addCommands(  //this is the one of our autons
                  new AutoPneuDeploy(), 
                  new WaitCommand(.5), 
                  new AutoIntakeOn(), 
                  new WaitCommand(.5), 
                  new AutoShoot(), 
                  new WaitCommand(.75), 
                  new AutoShootEnd(), 
                  new AutoForward(), 
                  new WaitCommand(1.7), 
                  new AutoReverse(), 
                  new WaitCommand(1.5), 
                  new AutoMoveEnd(), 
                  new AutoShoot(), 
                  new WaitCommand(.75), 
                  new AutoShootEnd(), 
                  new AutoIntakeOff(),
                  new Turnright(),
                  new WaitCommand(0.25),
                  new AutoForward(),
                  new WaitCommand(2.75),
                  new Turnright(),
                  new WaitCommand(0.75),
                  new AutoMoveEnd());
    addCommands();
  }
}
