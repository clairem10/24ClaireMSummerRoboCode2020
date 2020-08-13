package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class HatchLatcher extends SubsystemBase 
{
    private static HatchLatcher hl;
    private DoubleSolenoid extenderSolenoid;
    private DoubleSolenoid flowerSolenoid;
    
    private HatchLatcher()
    {
        extenderSolenoid = new DoubleSolenoid(RobotMap.EXTENDER_FORWARD, RobotMap.EXTENDER_REVERSE);
        flowerSolenoid = new DoubleSolenoid(RobotMap.FLOWER_FORWARD, RobotMap.FLOWER_REVERSE);
    }

    public static HatchLatcher getInstance()
    {
        if(hl==null) {
            hl = new HatchLatcher();
        } 
        return hl;
    }

    public DoubleSolenoid.Value invertValue (DoubleSolenoid.Value value)
    {
        if (value == DoubleSolenoid.Value.kForward) 
        {
            return DoubleSolenoid.Value.kReverse;
        }
        else
        {
            return DoubleSolenoid.Value.kForward;
        }
    }

    public DoubleSolenoid getExtenderSolenoid()
    {
        return extenderSolenoid;
    }

    public DoubleSolenoid getFlowerSolenoid()
    {
        return flowerSolenoid;
    }
}