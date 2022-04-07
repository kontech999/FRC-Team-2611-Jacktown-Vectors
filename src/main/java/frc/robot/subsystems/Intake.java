package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
//import com.revrobotics.CANSparkMax;
//import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Robot;
import frc.robot.commands.IntakeCommand;

public class Intake extends SubsystemBase {
  //Intake Motors
  private TalonSRX IntakeMotor = new TalonSRX(Constants.INTAKE_MOTOR_ID);
  private TalonSRX TransitionMotor = new TalonSRX(Constants.TRANSITION_MOTOR_ID);
  private static DoubleSolenoid m_solenoid = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, 2, 3);
  

  /** Creates a new Intake. */
  public Intake() {
    
  }

  @Override
  public void periodic() {
    setDefaultCommand(new IntakeCommand());
  }
  public void setintakemotor(double speed) {
    //method for controlling the intake motor
    IntakeMotor.set(ControlMode.PercentOutput, -speed);
  }
  public void settransitionmotor(double speed) {
    //method for controlling the transition motor which takes balls from the intake into the shooter
    TransitionMotor.set(ControlMode.PercentOutput, -speed);
  }
  public void IntakePneumatics() {
    //method for controlling the pneumatics that control whether our intake is down or up
    if (Robot.m_robotContainer.GetPneumaticsButton7()){
      m_solenoid.set(Value.kForward);
      SmartDashboard.putString("Pneumaticsforward", "yes");
    }
    else if (Robot.m_robotContainer.GetPneumaticsButton8()){
      m_solenoid.set(Value.kReverse);
      SmartDashboard.putString("PneumaticsReverse", "yes");
    }
  }
  public void AutoPneuDeployForwardMethod() {
    // this controls the intake pneumatics in auton
    m_solenoid.set(Value.kForward);
  }
  public void AutoPneuDeployReverseMethod() {
    // this controls the intake pneumatics in auton
    m_solenoid.set(Value.kReverse);
  }
}