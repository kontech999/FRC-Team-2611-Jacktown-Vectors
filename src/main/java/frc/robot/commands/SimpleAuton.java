package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitCommand;

public class SimpleAuton extends SequentialCommandGroup {
  public SimpleAuton() {
    addCommands(  
                  //this is the one of our autons
                  new AutoPneuDeploy(), 
                  new WaitCommand(1), 
                  new AutoIntakeOn(), 
                  new WaitCommand(1), 
                  new AutoShoot(), 
                  new WaitCommand(1), 
                  new AutoShootEnd(),
                  new AutoIntakeOff(), 
                  new AutoForward(), 
                  new WaitCommand(2.5),
                  new AutoMoveEnd());
    addCommands();
  }
}
// reed ate my son so im making a calout post on my twitter . com