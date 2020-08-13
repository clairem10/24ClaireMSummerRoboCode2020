package frc.robot.commands;

import harkerrobolib.commands.IndefiniteCommand;
import frc.robot.OI;
import frc.robot.subsystems.Drivetrain;

public class DriveWithPercentOutput extends IndefiniteCommand 
{
    public DriveWithPercentOutput()
    {
        addRequirements(Drivetrain.getInstance());
    }

    public void execute()
    {
        double turn = OI.getInstance().getDriverGamepad().getLeftX();
        double speed = OI.getInstance().getDriverGamepad().getLeftY();
        Drivetrain.getInstance().setPercentOutput(speed, turn);
    }
}