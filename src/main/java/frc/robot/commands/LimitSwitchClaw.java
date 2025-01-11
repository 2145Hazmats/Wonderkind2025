// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.Constants;
import frc.robot.subsystems.Claw;
import frc.robot.subsystems.Drivetrain;

public class LimitSwitchClaw extends Command {
  private Drivetrain drive;
  private Claw m_claw;
  /** Creates a new LimitSwitchClaw. */
  public LimitSwitchClaw(Drivetrain m_drive, Claw drie2) {
    // Use addRequirements() here to declare subsystem dependencies.
    drive = m_drive;
    m_claw = drie2;
    addRequirements(drie2);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {

    
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (drive.theotherlimitswitch == true && drive.isLimitSwitchClosed == true) {
      m_claw.clawClose(Constants.SpeedConstants.kClawCloseSpeed);
    }
    else if (drive.theotherlimitswitch ==true) {

      m_claw.clawShiftLeft(Constants.SpeedConstants.kClawShiftSpeed);
    }
    else if (drive.isLimitSwitchClosed == true){

      m_claw.clawShiftRight(Constants.SpeedConstants.kClawShiftSpeed);
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}
