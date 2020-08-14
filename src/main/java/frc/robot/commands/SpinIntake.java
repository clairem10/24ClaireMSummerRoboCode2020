package frc.robot.commands;

import harkerrobolib.commands.IndefiniteCommand;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.subsystems.Intake;

public class SpinIntake extends IndefiniteCommand
{
    private final double INTAKE_SPEED;
    public SpinIntake(double speed)
    {
        addRequirements(Intake.getInstance());
        INTAKE_SPEED = speed;
    }

    public void execute()
    {      
        Intake.getInstance().getIntakeMotor().set(ControlMode.PercentOutput, INTAKE_SPEED);      
    }
}