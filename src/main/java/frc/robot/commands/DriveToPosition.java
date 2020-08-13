package frc.robot.commands;

import com.ctre.phoenix.motorcontrol.ControlMode;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotMap;
import frc.robot.subsystems.Drivetrain;

public class DriveToPosition extends CommandBase 
{
    private int position;

    public DriveToPosition (int pos)
    {
        position = pos;
        addRequirements(Drivetrain.getInstance());
    }

    public void initialize() 
    {
        Drivetrain.getInstance().configPositionPIDConstants();
        Drivetrain.getInstance().getLeftMaster().setSelectedSensorPosition(0, RobotMap.LOOP_INDEX, 0);
        Drivetrain.getInstance().getRightMaster().setSelectedSensorPosition(0, RobotMap.LOOP_INDEX, 0);
    }

    public void execute() {
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Position , position);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Position , position);
    }
    
    public boolean isFinished() {
        boolean leftIsFinished=(Math.abs(Drivetrain.getInstance().getLeftMaster().getClosedLoopError())<Drivetrain.ALLOWABLE_ERROR);
        boolean rightIsFinished= (Math.abs(Drivetrain.getInstance().getRightMaster().getClosedLoopError())<Drivetrain.ALLOWABLE_ERROR);
        return (leftIsFinished && rightIsFinished);
    }
    
    public void end(boolean interrrupted) {
        Drivetrain.getInstance().getLeftMaster().set(ControlMode.Disabled , 0);
        Drivetrain.getInstance().getRightMaster().set(ControlMode.Disabled, 0); 
    }
}