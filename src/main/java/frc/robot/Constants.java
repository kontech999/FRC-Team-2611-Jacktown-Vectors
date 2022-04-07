package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
    //Motor IDs
    public static final int LEFT_MOTOR_1ID = 1;
    public static final int LEFT_MOTOR_2ID = 3;
    public static final int RIGHT_MOTOR_1ID = 2;
    public static final int RIGHT_MOTOR_2ID = 4;
    public static final int INTAKE_MOTOR_ID = 8;
    public static final int TRANSITION_MOTOR_ID = 7;
    public static final int FULL_SEND_MOTOR_ID = 5;
    public static final int FLY_WHEEL_MOTOR_ID = 6;
    public static final int SUPPORT_MOTOR_ID = 9;
    //OI IDs
    public static final int LEFT_JOYSTICK_ID = 0;
    public static final int RIGHT_JOYSTICK_ID = 1;
    public static final int RIGHT_JOYSTICK_YID = 1;
    public static final int LEFT_JOYSTICK_YID = 1;
    public static final int CLIMBER_JOYSTICK_ID = 2;
    public static final int CLIMBER_JOYSTICK_YID = 1;
    public static final int CLIMBER_MOTOR_ID = 10;
    public static final int CLIMBER_MOTORTWO_ID = 11;
    public static final int GAMEPAD_ID = 2;
    public static final int X_LEFT_JOYSTICK_ID = 1;
    public static final int X_RIGHT_JOYSTICK_ID = 5;

    //JOYSTICK button ID
    public static final int JOYSTICK_BUTTON_7_ID = 7;
    public static final int JOYSTICK_BUTTON_8_ID = 8;
    public static final int JOYSTICK_BUTTON_9_ID = 9;
    public static final int JOYSTICK_BUTTON_10_ID = 10;

    //XBOX button ID
    public static final int A_BUTTON_ID = 1;
    public static final int B_BUTTON_ID = 2;
    public static final int X_BUTTON_ID = 3;
    public static final int Y_BUTTON_ID = 4;

    public static final int kPIDLoopIdx = 0;
    public static final int kTimeoutsMs = 30;
    
    // Gains( double _kP, double _kI, double _kD, double _kF, int _kIzone, double _kPeakOutput)
    public final static Gains kGains_Velocit = new Gains( 1, 0.001, 5, 1023.0/20660.0, 300, 1.00);
    public static final double HIGH_SCORE = 1.22;
    public static final double LOWER_SCORE = 0.7;
    public static final double REVERSE_SHOOTER = -0.5;

    public final static Gains Support_kGains_Velocit = new Gains( 0.05, 0, 0, 1023.0/20660.0, 300, 1.00);
    public static final double SUPPORT_HIGH_SCORE = 0.96;
    public static final double SUPPORT_LOWER_SCORE = 0.3;

    //Speed Constants
    public static final double MOTOR_OFF = 0;
    public static final double TRANSITION_SPEED_MODIFIER = 0.75;
    public static final double INTAKE_SPEED_MODIFIER = 0.75;
    public static final double AUTO_SPEED = -0.25;
    public static final double HIGH_AUTO_SPEED = -0.15;

    //Misc
    public static final double SHOOT_HIGH = 2;
    public static final double SHOOT_LOW = 1;
    public static final double SHOOTER_REVERSE = -55;
    public static final double SHOOTER_STOP = 0;
    public static final double FULLSEND_MOTOR_ON = 1;
    public static final int SHOOTERDISTANCEID = 0;

    //public final static Gains Support_kGains_Velocit = new Gains( 1, 0.001, 5, 1023.0/20660.0, 300, 1.00);
    //Original Velocity 1.155
    // set to 1.24
    // set to 1.23
    //fine tune these numbers 
    //play with SUPPORT_HIGH_SCORE first then
    // kP.  
    // Gains( double _kP, double _kI, double _kD, double _kF, int _kIzone, double _kPeakOutput)
    //original 0.7
    
}