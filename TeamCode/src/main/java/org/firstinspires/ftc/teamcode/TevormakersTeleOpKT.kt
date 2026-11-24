package org.firstinspires.ftc.teamcode

import com.qualcomm.hardware.bosch.BHI260IMU
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.eventloop.opmode.TeleOp
import com.qualcomm.robotcore.hardware.DcMotorSimple
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference

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
                        //backRightMoter and frontRightMotor is reverse
                        backRightMotor.power = controlY
                        backLeftMotor.power = controlY
                        frontLeftMotor.power = controlY
                        frontRightMotor.power = controlY
                        backRightMotor.direction = DcMotorSimple.Direction.REVERSE
                        frontRightMotor.direction = DcMotorSimple.Direction.FORWARD
                        backLeftMotor.direction = DcMotorSimple.Direction.FORWARD
                        frontLeftMotor.direction = DcMotorSimple.Direction.REVERSE




                        val inTakeAndOutTake = gamepad1.a
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
                                backRightMotor.power = 1.0
                                backLeftMotor.power = -1.0
                                frontLeftMotor.power = -1.0
                                frontRightMotor.power = 1.0
                        }

                        val right = gamepad1.dpad_right
                        if(right) {
                                backRightMotor.power = -1.0
                                backLeftMotor.power = 1.0
                                frontLeftMotor.power = 1.0
                                frontRightMotor.power = -1.0
                        }

//                        val imuParameters = BHI260IMU.Parameters().apply {
//                                angleUnit = BHI260IMU.AngleUnit.DEGREES
//                                accelUnit = BHI260IMU.AccelUnit.METERS_PERSEC_PERSEC;
//                                loggingEnabled = false
//                        }
                        //BHI260AP
//                        val imu = hardwareMap.get(BHI260IMU::class.java, "imu")
//                        imu.initialize(imuParameters)


//                        val angles = imu.getAngularOrientation(
//                                AxesReference.INTRINSIC,
//                                AxesOrder.ZYX,
//                                AngleUnit.DEGREES
//                        )
//                        telemetry.addData("First Angle", angles.firstAngle)
//                        telemetry.addData("Second Angle", angles.secondAngle)
//                        telemetry.addData("Third Angle", angles.thirdAngle)
//                        telemetry.update()
                }



                //val controlX = gamepad1.left_stick_x.toDouble()
                //val rBumper = gamepad1.left_bumper
                //backRightMotor.power = 1.0
        }
}
