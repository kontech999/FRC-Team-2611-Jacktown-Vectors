package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.commands.Motordrive;

public class DriveTrain extends SubsystemBase {
  //creating an Instance of the motors
  private TalonFX LeftMotor1 = new TalonFX(Constants.LEFT_MOTOR_1ID);
  private TalonFX LeftMotor2 = new TalonFX(Constants.LEFT_MOTOR_2ID);
  private TalonFX RightMotor1 = new TalonFX(Constants.RIGHT_MOTOR_1ID);
  private TalonFX RightMotor2 = new TalonFX(Constants.RIGHT_MOTOR_2ID);
  private Encoder encoderl1 = new Encoder(0, 1); // we currently do not use encoders, but we are looking into it.
  /** Creates a new DriveTrain. */
  public DriveTrain() {
  
    //these motors need to be inverted so it can move forward
    LeftMotor1.setInverted(true);
    LeftMotor2.setInverted(true);
  }

  @Override
  public void periodic() {
    setDefaultCommand(new Motordrive());
  }
   // method so left and right motors move the same
  public void setleftmotor(double speed){
    LeftMotor1.set(ControlMode.PercentOutput, speed);
    LeftMotor2.set(ControlMode.PercentOutput, speed);
  }
  public void setrightmotor(double speed){
    RightMotor1.set(ControlMode.PercentOutput, speed);
    RightMotor2.set(ControlMode.PercentOutput, speed);

  }
  // these are methods for using encoders
  public void resetencodervalues(){
    encoderl1.reset();
  }
  public double getencoderleft1value(){
    return encoderl1.get();
  }

}