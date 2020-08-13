package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.HatchLatcher;

public class ToggleFlowerSolenoid extends InstantCommand
{
    public ToggleFlowerSolenoid()
    {
        addRequirements(HatchLatcher.getInstance());
    }

    public void initialize()
    {
        DoubleSolenoid.Value value = HatchLatcher.getInstance().invertValue(HatchLatcher.getInstance().getFlowerSolenoid().get());
        HatchLatcher.getInstance().getFlowerSolenoid().set(value);
    }
}