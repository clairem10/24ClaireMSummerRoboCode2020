package frc.robot.commands;

import harkerrobolib.commands.IndefiniteCommand;
import com.ctre.phoenix.motorcontrol.ControlMode;
import frc.robot.subsystems.Intake;

public class Outtake extends IndefiniteCommand
{
    private double speed;

    public Outtake(double speed)
    {
        addRequirements(Intake.getInstance());
        this.speed = speed;
    }

    public void initialize()
    {
        System.out.println("outtake command init");
        Intake.getInstance().getIntakeMotor().setInverted(!(Intake.INTAKE_IS_INVERTED));
    }
    
    public void execute()
    {      
        Intake.getInstance().getIntakeMotor().set(ControlMode.PercentOutput, speed);     
    }
    
    public void end(boolean interrupted)
    {
        Intake.getInstance().getIntakeMotor().set(ControlMode.Disabled, 0);
    }
}
