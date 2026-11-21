package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp

@TeleOp(name = "TevorMakersTeleOpKT", group = "TeleOp")
class TevorMakersTeleOpKT : LinearOpMode() {
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

                //repeat while running
                while (opModeIsActive()) {

                        val controlY = gamepad1.left_stick_y.toDouble()
                        val controlX = gamepad1.left_stick_y.toDouble()
                        //backRightMoter is reverse
                        backRightMotor.power = -controlY
                        backLeftMotor.power = controlY
                        frontLeftMotor.power = controlY
                        frontRightMotor.power = controlY


                        val inTakeAndOutTake = gamepad2.a
                        if(inTakeAndOutTake) {
                                intakeMotor.power = 1.0
                                shooter.power = -1.0
                        }
                        else {
                                intakeMotor.power = 0.0
                                shooter.power = 0.0
                        }

                        val left = gamepad1.dpad_left
                        if(left) {
                                backRightMotor.power = -1.0
                                backLeftMotor.power = 1.0
                                frontLeftMotor.power = 1.0
                                frontRightMotor.power = -1.0
                        }

                        val right = gamepad1.dpad_right
                        if(right) {
                                backRightMotor.power = 1.0
                                backLeftMotor.power = -1.0
                                frontLeftMotor.power = -1.0
                                frontRightMotor.power = 1.0
                        }

                }



                //val controlX = gamepad1.left_stick_x.toDouble()
                //val rBumper = gamepad1.left_bumper
                //backRightMotor.power = 1.0
        }
}
