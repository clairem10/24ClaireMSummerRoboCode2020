package frc.robot.commands;

import harkerrobolib.commands.IndefiniteCommand;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.OI;
import frc.robot.subsystems.Intake;


public class SpinIntake extends IndefiniteCommand
{
    public SpinIntake()
    {
        addRequirements(Intake.getInstance());
    }

    public void execute()
    {
        while(OI.getInstance().getDriverGamepad().getButtonAState())
        {
            Intake.getInstance().getIntakeMotor().set(ControlMode.PercentOutput, 0.5);
        }       
    }
}