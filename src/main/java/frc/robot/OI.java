package frc.robot;

import harkerrobolib.wrappers.HSGamepad;
import harkerrobolib.wrappers.XboxGamepad;
import frc.robot.commands.SpinIntake;
import frc.robot.commands.ToggleIntakeSolenoid;

public class OI
{
    private static OI oi;
    private HSGamepad driverGamepad;
    private HSGamepad operatorGamepad;

    private OI ()
    {
        driverGamepad=new XboxGamepad(0);
        operatorGamepad=new XboxGamepad(1);
        driverGamepad.getButtonB().whilePressed(new SpinIntake(0.5));
        driverGamepad.getButtonA().toggleWhenPressed(new ToggleIntakeSolenoid());
    }

    public static OI getInstance()
    {
        if(oi==null) {
            oi = new OI();
        } 
        return oi;
    }

    public HSGamepad getDriverGamepad()
    {
        return driverGamepad;
    }

    public HSGamepad getOperatorGamepad()
    {
        return operatorGamepad;
    }

}