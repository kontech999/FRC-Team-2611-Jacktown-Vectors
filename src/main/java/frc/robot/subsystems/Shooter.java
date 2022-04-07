// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.TalonFXFeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonFX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
//import frc.robot.Robot;
import frc.robot.commands.ShooterCommand;

public class Shooter extends SubsystemBase {
    //Shooter Motors
    private TalonFX FullSendMotor = new TalonFX(Constants.FULL_SEND_MOTOR_ID);
    private TalonFX FlyWheelMotor = new TalonFX(Constants.FLY_WHEEL_MOTOR_ID);
    private TalonFX SupportMotor = new TalonFX(Constants.SUPPORT_MOTOR_ID);
    //DigitalInput shooterdistance;
    double currentSpeed;
    double targetVelocity = Constants.LOWER_SCORE * 2000.0 * 2048.0 / 600.0;
    double SupportcurrentSpeed;
    
    double SupporttargetVelocity = Constants.SUPPORT_LOWER_SCORE * 2000.0 * 2048.0 / 600.0;
    boolean HIGHORLOW;
  /** Creates a new Shooter. */
  public Shooter() {
  
     }

   public void init(){
    //PID Initializations 
    FlyWheelMotor.configFactoryDefault();
    FlyWheelMotor.configNeutralDeadband(0.001);
    FlyWheelMotor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, Constants.kPIDLoopIdx, Constants.kTimeoutsMs);
    
    
    SupportMotor.configFactoryDefault();
    SupportMotor.setInverted(true);
    SupportMotor.configNeutralDeadband(0.001);
    SupportMotor.configSelectedFeedbackSensor(TalonFXFeedbackDevice.IntegratedSensor, Constants.kPIDLoopIdx, Constants.kTimeoutsMs);

    FlyWheelMotor.configNominalOutputForward(0, Constants.kTimeoutsMs);
    FlyWheelMotor.configNominalOutputReverse(0, Constants.kTimeoutsMs);
    FlyWheelMotor.configPeakOutputForward(1, Constants.kTimeoutsMs);
    FlyWheelMotor.configPeakOutputReverse(-1, Constants.kTimeoutsMs);

    SupportMotor.configNominalOutputForward(0, Constants.kTimeoutsMs);
    SupportMotor.configNominalOutputReverse(0, Constants.kTimeoutsMs);
    SupportMotor.configPeakOutputForward(1, Constants.kTimeoutsMs);
    SupportMotor.configPeakOutputReverse(-1, Constants.kTimeoutsMs);
    // Gains( double _kP, double _kI, double _kD, double _kF, int _kIzone, double _kPeakOutput
    // Gains( 0.1, 0.001, 5, 1023.0/20660.0, 300, 1.00)
    FlyWheelMotor.config_kF(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kF, Constants.kTimeoutsMs);
    FlyWheelMotor.config_kP(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kP, Constants.kTimeoutsMs);
    FlyWheelMotor.config_kI(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kI, Constants.kTimeoutsMs);
    FlyWheelMotor.config_kD(Constants.kPIDLoopIdx, Constants.kGains_Velocit.kD, Constants.kTimeoutsMs);

    SupportMotor.config_kF(Constants.kPIDLoopIdx, Constants.Support_kGains_Velocit.kF, Constants.kTimeoutsMs);
    SupportMotor.config_kP(Constants.kPIDLoopIdx, Constants.Support_kGains_Velocit.kP, Constants.kTimeoutsMs);
    SupportMotor.config_kI(Constants.kPIDLoopIdx, Constants.Support_kGains_Velocit.kI, Constants.kTimeoutsMs);
    SupportMotor.config_kD(Constants.kPIDLoopIdx, Constants.Support_kGains_Velocit.kD, Constants.kTimeoutsMs);

   }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    //shooterdistance = new DigitalInput(Constants.SHOOTERDISTANCEID);
    setDefaultCommand(new ShooterCommand());

  }
  public void setfullsendmotor(double speed) {
    //This is the method for controlling our fullsend Motor
    FullSendMotor.set(ControlMode.PercentOutput, speed);
  }
  public double setflywheelmotor(double speed) {
    //this is the method for controlling our flywheel and support motors
    if (speed == 1.0) {
      targetVelocity = Constants.LOWER_SCORE * 2000.0 * 2048.0 / 600.0;
      FlyWheelMotor.set(ControlMode.Velocity, targetVelocity);
      //SupporttargetVelocity = Constants.SUPPORT_LOWER_SCORE * 2000.0 * 2048.0 / 600.0;
      //SupportMotor.set(ControlMode.Velocity, SupporttargetVelocity);
      SupportMotor.set(ControlMode.PercentOutput, 0);

    } else if (speed == -55.0){
      //targetVelocity = Constants.REVERSE_SHOOTER * 2000.0 * 2048.0 / 600.0;
      //SupporttargetVelocity = Constants.REVERSE_SHOOTER * 2000.0 * 2048.0 / 600.0;
    } else if (speed == 2.0){
      targetVelocity = Constants.HIGH_SCORE * 2000.0 * 2048.0 / 600.0;
      FlyWheelMotor.set(ControlMode.Velocity, targetVelocity);
      SupporttargetVelocity = Constants.SUPPORT_HIGH_SCORE * 2000.0 * 2048.0 / 600.0;
      SupportMotor.set(ControlMode.Velocity, SupporttargetVelocity);
      

    } else {
      FlyWheelMotor.set(ControlMode.Velocity, 0);
      FlyWheelMotor.set(ControlMode.PercentOutput,0);
      //SupportMotor.set(ControlMode.Velocity, 0);
      SupportMotor.set(ControlMode.PercentOutput,0);
    }
    currentSpeed = FlyWheelMotor.getSelectedSensorVelocity();
    
    return currentSpeed;
  }

  /*public boolean shooterdistancemethod(){
    return shooterdistance.get();
  }
  */
}