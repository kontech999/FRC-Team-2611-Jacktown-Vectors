package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.HighAutonPos3;
import frc.robot.commands.Positionone;
import frc.robot.commands.Positionthree;
import frc.robot.commands.Positiontwo;
import frc.robot.commands.SimpleAuton;
import frc.robot.commands.threehighpos2;
import frc.robot.commands.twohighpos3;

public class RobotContainer {
  //these are our several autons
  private final Command m_simpleAuto =
    new SimpleAuton();
  private final Command m_positionone =
    new Positionone();
  private final Command m_positiontwo =
    new Positiontwo();
  private final Command m_positionthree =
    new Positionthree();
  private final Command m_highposition3 =
    new HighAutonPos3();
  private final Command m_doublehighpos3 =
    new twohighpos3();
  private final Command m_triplehighpos3 =
    new threehighpos2();
  SendableChooser<Command> m_chooser = new SendableChooser<>();
  
  
  
  public Command getautonomousCommand(){

    return m_chooser.getSelected();
  }
  //Instances our joysticks
  private Joystick Leftjoy = new Joystick(Constants.LEFT_JOYSTICK_ID);
  private Joystick Rightjoy = new Joystick(Constants.RIGHT_JOYSTICK_ID);
  private XboxController Gamepad = new XboxController(Constants.GAMEPAD_ID);
    
  //joystick axises
  public double GetleftjoyRawAxis(int laxis){
    return Leftjoy.getRawAxis(laxis);
  }
  public double GetRightjoyRawAxis(int raxis){
    return Rightjoy.getRawAxis(raxis);
  }

  //Gamepad Axises
  public double GetGamepadRawLeftAxis(int leftaxis){
    return Gamepad.getRawAxis(leftaxis);
  }
  public double GetGamepadRawRightAxis(int rightaxis){
    return Gamepad.getRawAxis(rightaxis);
  }
  
  //Gamepad Triggers
  public double GetGamepadRawL() {
    return Gamepad.getLeftTriggerAxis();
  }
  public double GetGamepadRawR() {
    return Gamepad.getRightTriggerAxis();
  }

  //Xbox buttons
  public boolean GetGamepadRawButton(int button){
    return Gamepad.getRawButton(button);
  }

  //Joystick Buttons
  public boolean GetPneumaticsButton7(){
    return Leftjoy.getRawButton(Constants.JOYSTICK_BUTTON_7_ID);
  }
  public boolean GetPneumaticsButton8(){
    return Leftjoy.getRawButton(Constants.JOYSTICK_BUTTON_8_ID);
  }
  public boolean GetPneumaticsButton9(){
    return Leftjoy.getRawButton(Constants.JOYSTICK_BUTTON_9_ID);
  }
  public boolean GetPneumaticsButton10(){
    return Leftjoy.getRawButton(Constants.JOYSTICK_BUTTON_10_ID);
  }
  public RobotContainer() {
    //this allows us to input the auton we want in smartdashboard
    m_chooser.setDefaultOption("Position 3", m_positionthree);
    m_chooser.addOption("Position 2", m_positiontwo);
    m_chooser.addOption("Position 1", m_positionone);
    m_chooser.addOption("Simple Auton", m_simpleAuto);
    m_chooser.addOption("1 High shoot position 3 ", m_highposition3);
    m_chooser.addOption("Double shoot high position 3", m_doublehighpos3);
    m_chooser.addOption("triple shoot high position 2", m_triplehighpos3);
    configureButtonBindings();
  }
  private void configureButtonBindings() {}
}