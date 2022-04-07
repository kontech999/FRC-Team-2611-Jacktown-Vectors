package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.Robot;

public class ShooterCommand extends CommandBase {
  
  boolean ShooterOn;
  boolean ShooterDebounce;
  boolean SwitchDebounce;
  boolean ShootLow;
  boolean ReverShooterOn;
  boolean ReverShooterDebounce;
  boolean HIGHORLOW;
  double CurrentSpeed = 0;

  /** Creates a new ShooterCommand. */
  public ShooterCommand() {
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(Robot.shooter);
    ShooterOn = false;
    ShooterDebounce = false;
    SwitchDebounce = false;
    ReverShooterDebounce = false;
    ReverShooterOn = false;
    ShootLow = true;
  }

  @Override
  public void initialize() {}

  @Override
  public void execute() {
     //gets Xbox button
     boolean ButtonA = Robot.m_robotContainer.GetGamepadRawButton(Constants.A_BUTTON_ID);
     boolean ButtonB = Robot.m_robotContainer.GetGamepadRawButton(Constants.B_BUTTON_ID);
     boolean ButtonX = Robot.m_robotContainer.GetGamepadRawButton(Constants.X_BUTTON_ID);
     boolean ButtonY = Robot.m_robotContainer.GetGamepadRawButton(Constants.Y_BUTTON_ID);
     boolean Button9 = Robot.m_robotContainer.GetPneumaticsButton9();
    
     //smartdashboard values
     //SmartDashboard.putNumber("Shooter Speed = ", CurrentSpeed);
     SmartDashboard.putBoolean("Shooter on =", ShooterOn);
     //SmartDashboard.putBoolean("Shooter in Reverse", ReverShooterOn);
     SmartDashboard.putBoolean("Shooter Mode Low", ShootLow);
     //SmartDashboard.putBoolean("Shooter Distance", Robot.shooter.shooterdistancemethod());
     //set Xbox Motors
     // if Button A is pressed, Toggle ShooeterOn On/OFF 
     if(ButtonA==true && ShooterDebounce==false){
        ShooterOn = !ShooterOn;
        ShooterDebounce= true;
     }
     if(ButtonA==false && ShooterDebounce== true){
        ShooterDebounce = false;
     }
      
     //reverse fly wheel
     // if Button B is pressed, Toggle ReverShooterOn On/OFF 
    if(ButtonB==true && ReverShooterDebounce==false){
        ReverShooterOn = !ReverShooterOn;
        ReverShooterDebounce= true;
    }
    if(ButtonB==false && ReverShooterDebounce==true){
        ReverShooterDebounce = false;
    }
    //
    if(Button9==true && SwitchDebounce==false){
      ShootLow = !ShootLow;
      SwitchDebounce= true;
   }
   if(Button9==false && SwitchDebounce== true){
      SwitchDebounce = false;
   }  
   if (ShooterOn==true){
       if (ReverShooterOn == false) { 
          if (ShootLow) {
            //Turn Shooter ON in forward direction
              CurrentSpeed = Robot.shooter.setflywheelmotor(Constants.SHOOT_LOW);

          }else {
              CurrentSpeed = Robot.shooter.setflywheelmotor(Constants.SHOOT_HIGH);
          }
        } else {
          //Turn Shooter ON in reverse direction
            CurrentSpeed = Robot.shooter.setflywheelmotor(Constants.SHOOTER_REVERSE);
       }
     }
     else if(ShooterOn==false ){
          //Turn Shooter OFF
          CurrentSpeed = Robot.shooter.setflywheelmotor(Constants.SHOOTER_STOP);
     }

     
     //If Button X, turn INTAKE moter on in forward direction
     //else if Button Y, turn INTAKE moter on in Reverse direction
     //else turn INTAKE motor off
     if(ButtonX==true && ShooterOn==true){
      Robot.shooter.setfullsendmotor(0.77);
     }
     else if(ButtonY==true ){
      Robot.shooter.setfullsendmotor(-0.77);
     }
     else {
      Robot.shooter.setfullsendmotor(Constants.MOTOR_OFF);
     }
     //reverse Intake  
  }

  @Override
  public void end(boolean interrupted) {
    Robot.shooter.setflywheelmotor(Constants.MOTOR_OFF);
    Robot.shooter.setfullsendmotor(Constants.MOTOR_OFF);
  }

  @Override
  public boolean isFinished() {
    return false;
  }
}