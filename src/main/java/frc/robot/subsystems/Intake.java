package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import harkerrobolib.wrappers.HSTalon;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import frc.robot.RobotMap;

public class Intake extends SubsystemBase
{
    private HSTalon intakeMotor;
    private DoubleSolenoid intakeSolenoid;
    private static Intake it;
    public static final boolean INTAKE_IS_INVERTED = true;

    private Intake ()
    {
        intakeMotor = new HSTalon(RobotMap.IM);
        intakeSolenoid = new DoubleSolenoid(RobotMap.INTAKE_FORWARD, RobotMap.INTAKE_REVERSE);
    }

    public static Intake getInstance()
    {
        if(it==null) {
            it = new Intake();
        } 
        return it;
    }

    public HSTalon getIntakeMotor()
    {
        return intakeMotor;
    }

    public DoubleSolenoid getIntakeSolenoid()
    {
        return intakeSolenoid;
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
}