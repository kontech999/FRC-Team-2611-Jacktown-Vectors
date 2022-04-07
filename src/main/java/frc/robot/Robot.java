package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
//import edu.wpi.first.cscore.MjpegServer;
import edu.wpi.first.cscore.UsbCamera;

//import edu.wpi.first.cscore.VideoMode.PixelFormat;
//import edu.wpi.first.networktables.NetworkTable;
//import edu.wpi.first.networktables.NetworkTableEntry;
//import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.Climber;
import frc.robot.subsystems.DriveTrain;
import frc.robot.subsystems.Intake;
import frc.robot.subsystems.Shooter;

public class Robot extends TimedRobot {
  private Command m_autonomousCommand;
// private VictorSP m_Left0 = new VictorSP(0);
//  private VictorSP m_Left1 = new VictorSP(1);
//  private VictorSP m_right0 = new VictorSP(2);
//  private VictorSP m_right1 = new VictorSP(3);
/*
  //we were trying to get limelight working, no success so far
  NetworkTable table = NetworkTableInstance.getDefault().getTable("limelight");
  NetworkTableEntry tx = table.getEntry("tx");
  NetworkTableEntry ty = table.getEntry("ty");
  NetworkTableEntry ta = table.getEntry("ta");

  double x =tx.getDouble(0.0);
  double y =ty.getDouble(0.0);
  double area =ta.getDouble(0.0);
*/
  public static DriveTrain drivetrain = new DriveTrain();
  public static Intake intake = new Intake();
  public static Shooter shooter = new Shooter();
  public static Climber climber = new Climber();
  public static RobotContainer m_robotContainer;
  Thread m_visionThread1;
  Thread m_visionThread2;
  //UsbCamera camera = new UsbCamera("camerashoot", 0);
  @Override
  public void robotInit() {
    shooter.init();
    m_robotContainer = new RobotContainer();
    //this is the shooter camera
    m_visionThread1 =
        new Thread(
            () -> {
              // Get the UsbCamera from CameraServer
              UsbCamera camera = CameraServer.startAutomaticCapture("ShooterView",0);
              // Set the resolution
              camera.setResolution(160, 120);
              camera.setFPS(1);
            });
    m_visionThread1.setDaemon(true);
    m_visionThread1.start();

    m_visionThread2 =
        new Thread(
            () -> {
              // Get the UsbCamera from CameraServer
              UsbCamera intakecamera = CameraServer.startAutomaticCapture("IntakeView",1);
              // Set the resolution
              intakecamera.setResolution(160, 120);
              intakecamera.setFPS(1);
             });
    m_visionThread2.setDaemon(true);
    m_visionThread2.start();




    /*
    UsbCamera shootercamera = CameraServer.startAutomaticCapture(0);
    shootercamera.setResolution(160, 120);
    shootercamera.setFPS(1);
    */
    //this was the giant block of code that we didn't understand and didn't make sense
    /*
    UsbCamera usbCamera = new UsbCamera("USB Camera 0", 0);
    MjpegServer mjpegServer1 = new MjpegServer("serve_USB Camera 0", 1181);
    mjpegServer1.setSource(usbCamera);
    CvSink cvsink1 = new CvSink("opencv_USB Camera 0");
    cvsink1.setSource(usbCamera);
    CvSource outputStream = new CvSource("shooter", PixelFormat.kMJPEG, 160, 120, 10);
    MjpegServer mjpegServer2 = new MjpegServer("serve_shooter", 1182);
    mjpegServer2.setSource(outputStream);*/

    // this is the intake camera
    //UsbCamera intakecamera = CameraServer.startAutomaticCapture(1); 
    //intakecamera.setResolution(160, 120);
    //intakecamera.setFPS(1);
    
    
    SmartDashboard.putData(m_robotContainer.m_chooser);

    //limelight stuff
    //SmartDashboard.putNumber("limelightx", x);
    //SmartDashboard.putNumber("limelighty", y);
    //SmartDashboard.putNumber("limelightArea", area);
    //SmartDashboard.putData(m_robotContainer.m_chooser);
  }
  @Override
  public void robotPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  @Override
  public void autonomousInit() {
    m_autonomousCommand = m_robotContainer.getautonomousCommand();
    if (m_autonomousCommand != null) {
      m_autonomousCommand.schedule();
    }
    
  }

  @Override
  public void autonomousPeriodic() {}

  @Override
  public void teleopInit() {
    if (m_autonomousCommand != null) {
      m_autonomousCommand.cancel();
    }
  }

  @Override
  public void teleopPeriodic() {
    
  }

  @Override
  public void testInit() {
    CommandScheduler.getInstance().cancelAll();
  }

  @Override
  public void testPeriodic() {}
}