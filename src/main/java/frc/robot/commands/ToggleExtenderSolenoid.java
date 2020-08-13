package frc.robot.commands;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.subsystems.HatchLatcher;

public class ToggleExtenderSolenoid extends InstantCommand 
{
    public ToggleExtenderSolenoid()
    {
        addRequirements(HatchLatcher.getInstance());
    }

    public void initialize()
    {
        DoubleSolenoid.Value value = HatchLatcher.getInstance().invertValue(HatchLatcher.getInstance().getExtenderSolenoid().get());
        HatchLatcher.getInstance().getExtenderSolenoid().set(value);
    }
}
