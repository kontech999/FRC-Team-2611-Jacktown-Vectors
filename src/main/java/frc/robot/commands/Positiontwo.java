package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class Positiontwo extends SequentialCommandGroup {
  public Positiontwo() {
    addCommands(  //this is the one of our autons
                  new AutoPneuDeploy(), 
                  new WaitCommand(0.5), 
                  new AutoIntakeOn(), 
                  new WaitCommand(0.5), 
                  //new AutoShoot(), 
                  //new WaitCommand(0.75), 
                  //new AutoShootEnd(), 
                  new Autoslightleft(), 
                  new WaitCommand(2.5), 
                  new Autoreverseslightleft(), 
                  new WaitCommand(2.75), 
                  new Turnleft(),
                  new WaitCommand(0.2),
                  new AutoMoveEnd(),
                  new AutoShoot(), 
                  new WaitCommand(1), 
                  new AutoShootEnd(), 
                  new AutoIntakeOff(),
                  new WaitCommand(0.5),
                  new Turnright(),
                  new WaitCommand(0.15),
                  new Autoslightleft(),
                  new WaitCommand(2),
                  new Turnright(),
                  new WaitCommand(0.15),
                  new AutoMoveEnd());
    addCommands();
  }
}
