package org.firstinspires.ftc.teamcode

import com.qualcomm.hardware.bosch.BNO055IMU
import com.qualcomm.robotcore.eventloop.opmode.Autonomous
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit
import org.firstinspires.ftc.robotcore.external.navigation.AxesOrder
import org.firstinspires.ftc.robotcore.external.navigation.AxesReference

@Autonomous(name = "TrevorMakersAutonomous", group = "Autonomous")
class  TrevorMakersAutonomous : LinearOpMode() {

    //wheel diameter 3.75 inches
    fun driveForward(frontLeftMotor: DcMotor, frontRightMotor: DcMotor, backLeftMotor: DcMotor, backRightMotor: DcMotor, targetPosition: Int){
        frontLeftMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
        frontRightMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
        backLeftMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
        backRightMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER

        frontLeftMotor.mode = DcMotor.RunMode.RUN_USING_ENCODER
        frontRightMotor.mode = DcMotor.RunMode.RUN_USING_ENCODER
        backLeftMotor.mode = DcMotor.RunMode.RUN_USING_ENCODER
        backRightMotor.mode = DcMotor.RunMode.RUN_USING_ENCODER

        frontLeftMotor.targetPosition = targetPosition
        frontRightMotor.targetPosition = targetPosition
        backLeftMotor.targetPosition = targetPosition
        backRightMotor.targetPosition = targetPosition

        frontLeftMotor.mode = DcMotor.RunMode.RUN_TO_POSITION
        frontRightMotor.mode = DcMotor.RunMode.RUN_TO_POSITION
        backLeftMotor.mode = DcMotor.RunMode.RUN_TO_POSITION
        backRightMotor.mode = DcMotor.RunMode.RUN_TO_POSITION

        frontLeftMotor.power = 0.5
        frontRightMotor.power = 0.5
        backLeftMotor.power = 0.5
        backRightMotor.power = 0.5

        while(opModeIsActive() && (frontLeftMotor.isBusy || frontRightMotor.isBusy || backLeftMotor.isBusy || backRightMotor.isBusy)) {
            telemetry.addData("FL Current Position", frontLeftMotor.currentPosition)
            telemetry.addData("FR Current Position", frontRightMotor.currentPosition)
            telemetry.addData("BL Current Position", backLeftMotor.currentPosition)
            telemetry.addData("BR Current Position", backRightMotor.currentPosition)
            telemetry.update()
        }

        frontLeftMotor.power = 0.0
        frontRightMotor.power = 0.0
        backRightMotor.power = 0.0
        backLeftMotor.power = 0.0

    }

    override fun runOpMode() {
        // Create the motors
        val frontLeftMotor = hardwareMap.dcMotor.get("front_left_drive")
        val frontRightMotor = hardwareMap.dcMotor.get("front_right_drive")
        val backLeftMotor = hardwareMap.dcMotor.get("back_left_drive")
        val backRightMotor = hardwareMap.dcMotor.get("back_right_drive")

        val intakeMotor = hardwareMap.dcMotor.get("intake")
        val shooter = hardwareMap.dcMotor.get("shooter")


        //first autonomous = go forward than shoot
        //second autonomous = go right, forward, right forward, right forward shoot
        //BHI260AP



        backRightMotor.direction = DcMotorSimple.Direction.REVERSE
        frontRightMotor.direction = DcMotorSimple.Direction.FORWARD
        backLeftMotor.direction = DcMotorSimple.Direction.FORWARD
        frontLeftMotor.direction = DcMotorSimple.Direction.REVERSE

        //print to the driver hub
        telemetry.addLine("Initialized - waiting for start")
        telemetry.update()

        waitForStart()

        driveForward(frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor, -1000)




//        hardwareMap.dcMotor.resetEncoders()
//        val ticks = motor.getCurrentPosition()package org.firstinspires.ftc.teamcode
//
//import com.qualcomm.robotcore.eventloop.opmode.Autonomous
//import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode
//import com.qualcomm.robotcore.hardware.DcMotor
//import com.qualcomm.robotcore.hardware.DcMotorSimple
//
//@Autonomous(name = "TrevorMakersAutonomous", group = "Autonomous")
//class TrevorMakersAutonomous : LinearOpMode() {
//
//    fun driveForward(frontLeftMotor: DcMotor, frontRightMotor: DcMotor, backLeftMotor: DcMotor, backRightMotor: DcMotor, targetPosition: Int){
//
//
//
//        frontLeftMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
//        frontRightMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
//        backLeftMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
//        backRightMotor.mode = DcMotor.RunMode.STOP_AND_RESET_ENCODER
//
//        frontLeftMotor.mode = DcMotor.RunMode.RUN_USING_ENCODER
//        frontRightMotor.mode = DcMotor.RunMode.RUN_USING_ENCODER
//        backLeftMotor.mode = DcMotor.RunMode.RUN_USING_ENCODER
//        backRightMotor.mode = DcMotor.RunMode.RUN_USING_ENCODER
//
//        frontLeftMotor.targetPosition = targetPosition
//        frontRightMotor.targetPosition = targetPosition
//        backLeftMotor.targetPosition = targetPosition
//        backRightMotor.targetPosition = targetPosition
//
//        frontLeftMotor.mode = DcMotor.RunMode.RUN_TO_POSITION
//        frontRightMotor.mode = DcMotor.RunMode.RUN_TO_POSITION
//        backLeftMotor.mode = DcMotor.RunMode.RUN_TO_POSITION
//        backRightMotor.mode = DcMotor.RunMode.RUN_TO_POSITION
//
//        frontLeftMotor.power = 0.5
//        frontRightMotor.power = 0.5
//        backLeftMotor.power = 0.5
//        backRightMotor.power = 0.5
//
//        while(opModeIsActive() && (frontLeftMotor.isBusy || frontRightMotor.isBusy || backLeftMotor.isBusy || backRightMotor.isBusy)) {
//            telemetry.addData("FL Current Position", frontLeftMotor.currentPosition)
//            telemetry.addData("FR Current Position", frontRightMotor.currentPosition)
//            telemetry.addData("BL Current Position", backLeftMotor.currentPosition)
//            telemetry.addData("BR Current Position", backRightMotor.currentPosition)
//            telemetry.update()
//        }
//
//        frontLeftMotor.power = 0.0
//        frontRightMotor.power = 0.0
//        backRightMotor.power = 0.0
//        backLeftMotor.power = 0.0
//
//    }
//
//    override fun runOpMode() {
//        // Create the motors
//        val frontLeftMotor = hardwareMap.dcMotor.get("front_left_drive")
//        val frontRightMotor = hardwareMap.dcMotor.get("front_right_drive")
//        val backLeftMotor = hardwareMap.dcMotor.get("back_left_drive")
//        val backRightMotor = hardwareMap.dcMotor.get("back_right_drive")
//
//        val intakeMotor = hardwareMap.dcMotor.get("intake")
//        val shooter = hardwareMap.dcMotor.get("shooter")
//        val targetPosition = 1000
//
//
//
//        backRightMotor.direction = DcMotorSimple.Direction.REVERSE
//        frontRightMotor.direction = DcMotorSimple.Direction.FORWARD
//        backLeftMotor.direction = DcMotorSimple.Direction.FORWARD
//        frontLeftMotor.direction = DcMotorSimple.Direction.REVERSE
//
//        //print to the driver hub
//        telemetry.addLine("Initialized - waiting for start")
//        telemetry.update()
//
//        waitForStart()
//
//        driveForward(frontLeftMotor, frontRightMotor, backLeftMotor, backRightMotor, targetPosition)
//
//
//
//
////        hardwareMap.dcMotor.resetEncoders()
////        val ticks = motor.getCurrentPosition()
////        var currentState = 0;
////
////        when (currentState) {
////            0 -> {
////
////                driveForwardDistance(1000)
////            }
////
////            1 -> {
////
////            }
////        }
//
//
//    }
//}
//        var currentState = 0;
//
//        when (currentState) {
//            0 -> {
//
//                driveForwardDistance(1000)
//            }
//
//            1 -> {
//
//            }
//        }


    }
}