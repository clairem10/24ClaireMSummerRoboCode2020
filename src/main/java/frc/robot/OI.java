package frc.robot;

import harkerrobolib.wrappers.HSGamepad;
import harkerrobolib.wrappers.XboxGamepad;

public class OI
{
    private static OI oi;
    private HSGamepad driverGamepad;
    private HSGamepad operatorGamepad;

    private OI ()
    {
        driverGamepad=new XboxGamepad(0);
        operatorGamepad=new XboxGamepad(1);
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