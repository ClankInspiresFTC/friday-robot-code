package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp

@TeleOp(name = "TrevorMakersAutonomous", group = "TeleOp")
class TrevorMakersAutonomous : LinearOpMode() {
    override fun runOpMode() {
        // Create the motors
        val frontLeftMotor = hardwareMap.dcMotor.get("front_left_drive")
        val frontRightMotor = hardwareMap.dcMotor.get("front_right_drive")
        val backLeftMotor = hardwareMap.dcMotor.get("back_left_drive")
        val backRightMotor = hardwareMap.dcMotor.get("back_right_drive")

        val intakeMotor = hardwareMap.dcMotor.get("intake")
        val shooter = hardwareMap.dcMotor.get("shooter")

        //print to the driver hub
        telemetry.addLine("Initialized - waiting for start")
        telemetry.update()

        waitForStart()

        hardwareMap.dcMotor.resetEncoders()
        val ticks = motor.getCurrentPosition()
        var currentState = 0;

        when(currentState){
            0 -> {
                driveForwardDistance(1000)
            }
            1 -> {

            }
        }
    }
    
    fun driveForwardDistance(distanceTicks: Double) {
        hardwareMap.dcMotor.resetEncoders()
        val ticks = motor.getCurrentPosition()
        while(ticks < distanceTicks) {
            frontLeftMotor.power = 1.0
            frontRightMotor.power = 1.0
            backLeftMotor.power = 1.0
            backRightMotor.power = 1.0
        }
        frontLeftMotor.power = 0.0
        frontRightMotor.power = 0.0
        backLeftMotor.power = 0.0
        backRightMotor.power = 0.0
    }
    fun turnToAngle(angle: Double) {
        
    }
}