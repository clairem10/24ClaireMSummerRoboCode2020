package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;
import harkerrobolib.wrappers.HSTalon;

public class Drivetrain extends SubsystemBase
{
    private static Drivetrain dt;
    private HSTalon leftMaster;
    private HSTalon leftFollower;
    private HSTalon rightMaster;
    private HSTalon rightFollower;
    private static final boolean LM_IS_INVERTED = false;
    private static final boolean LF_IS_INVERTED = false;
    private static final boolean RM_IS_INVERTED = false;
    private static final boolean RF_IS_INVERTED = false;
    private static final boolean LEFT_SENSOR_PHASE = false;
    private static final boolean RIGHT_SENSOR_PHASE = false;
    private static final int LEFT_P = 0;
    private static final int RIGHT_P = 0;
    private static final int LEFT_I = 0;
    private static final int RIGHT_I = 0;
    private static final int LEFT_D = 0;
    private static final int RIGHT_D = 0;
    private static final int SLOT_INDEX = 0;
    public static final int ALLOWABLE_ERROR = 0;

    private Drivetrain()
    {
        leftMaster = new HSTalon(RobotMap.LM);
        leftFollower = new HSTalon(RobotMap.LF);
        rightMaster = new HSTalon(RobotMap.RM);
        rightFollower = new HSTalon(RobotMap.RF);
    }

    public static Drivetrain getInstance()
    {
        if(dt==null) {
            dt = new Drivetrain();
        } 

        return dt;
    }

    public void talonInit()
    {
        //factory reset
        leftMaster.configFactoryDefault();
        leftFollower.configFactoryDefault();
        rightMaster.configFactoryDefault();
        rightFollower.configFactoryDefault();
        //follow master
        leftFollower.follow(leftMaster);
        rightFollower.follow(rightMaster);
        //set inverts
        leftMaster.setInverted(LM_IS_INVERTED);
        leftFollower.setInverted(LF_IS_INVERTED);
        rightMaster.setInverted(RM_IS_INVERTED);
        rightFollower.setInverted(RF_IS_INVERTED);
        //set sensor phase
        leftMaster.setSensorPhase(LEFT_SENSOR_PHASE);
        rightMaster.setSensorPhase(RIGHT_SENSOR_PHASE);
    }
    
    public void setPercentOutput(double speed, double turn)
    {  
        double leftValue = speed+turn;
        double rightValue = speed-turn;
        leftMaster.set(ControlMode.PercentOutput, leftValue);
        rightMaster.set(ControlMode.PercentOutput, rightValue);
    }

    public void configPositionPIDConstants() 
    {
        leftMaster.config_kP(SLOT_INDEX, LEFT_P);
        leftMaster.config_kI(SLOT_INDEX, LEFT_I);
        leftMaster.config_kD(SLOT_INDEX, LEFT_D);
        rightMaster.config_kP(SLOT_INDEX, RIGHT_P);
        rightMaster.config_kI(SLOT_INDEX, RIGHT_I);
        rightMaster.config_kD(SLOT_INDEX, RIGHT_D);
        leftMaster.selectProfileSlot(SLOT_INDEX, RobotMap.LOOP_INDEX);
        rightMaster.selectProfileSlot(SLOT_INDEX, RobotMap.LOOP_INDEX);
        leftMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.LOOP_INDEX, 0);
        rightMaster.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Relative, RobotMap.LOOP_INDEX, 0);     
    }
    
    public HSTalon getLeftMaster()
    {
        return leftMaster;
    }

    public HSTalon getRightMaster()
    {
        return rightMaster;
    }
}