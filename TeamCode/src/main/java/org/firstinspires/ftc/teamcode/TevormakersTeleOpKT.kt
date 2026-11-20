package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp

@TeleOp(name = "TevormakersTeleOpKT", group = "TeleOp")
class TevormakersTeleOpKT : LinearOpMode() {
        override fun runOpMode() {

                // Create the motors
                val frontLeftMotor = hardwareMap.dcMotor.get("front_left_drive")
                val frontRightMotor = hardwareMap.dcMotor.get("front_right_drive")
                val backLeftMotor = hardwareMap.dcMotor.get("back_left_drive")
                val backRightMotor = hardwareMap.dcMotor.get("back_right_drive")
                val intakeMotor = hardwareMap.dcMotor.get("intake")

                //print to the driver hub
                telemetry.addLine("Initialized - waiting for start")
                telemetry.update()

                waitForStart()

                //repeat while running
                while (opModeIsActive()) {
                        //val controlY = gamepad1.left_stick_y.toDouble()
                        //val rBumper = gamepad1.left_bumper
                        //backRightMotor.power = 0.0
                }
        }
}