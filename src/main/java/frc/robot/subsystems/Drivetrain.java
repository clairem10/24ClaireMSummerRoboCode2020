package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase
{
    private static Drivetrain dt;
    private static HSTalon leftMaster;
    private static HSTalon leftFollower;
    private static HSTalon rightMaster;
    private static HSTalon rightFollower;
    private Drivetrain()
    {
    }
    public static Drivetrain getInstance()
    {
        if(dt==null) {
            dt = new Drivetrain();
        } 

        return dt;
    }
    public static HSTalon talonInit()
    {
        
    } 
}