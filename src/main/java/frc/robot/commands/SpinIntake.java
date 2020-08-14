package frc.robot.commands;

import harkerrobolib.commands.IndefiniteCommand;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.subsystems.Intake;

public class SpinIntake extends IndefiniteCommand
{
    private double speed;
    public SpinIntake(double speed)
    {
        addRequirements(Intake.getInstance());
        this.speed = speed;
    }

    public void initialize()
    {
        System.out.println("intake command init");
    }
    
    public void execute()
    {      
        Intake.getInstance().getIntakeMotor().set(ControlMode.PercentOutput, speed);     
    }
    
    public void end()
    {
        Intake.getInstance().getIntakeMotor().set(ControlMode.Disabled, 0);
    }
}
