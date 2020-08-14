package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.Intake;

public class ToggleIntakeSolenoid extends InstantCommand
{
    public ToggleIntakeSolenoid()
    {
        addRequirements(Intake.getInstance());
    }

    public void initialize()
    {
        DoubleSolenoid.Value value = Intake.getInstance().invertValue(Intake.getInstance().getIntakeSolenoid().get());
        Intake.getInstance().getIntakeSolenoid().set(value);
    }
}