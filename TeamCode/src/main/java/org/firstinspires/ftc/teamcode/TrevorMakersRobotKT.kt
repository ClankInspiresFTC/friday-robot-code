package org.firstinspires.ftc.teamcode

import com.qualcomm.robotcore.hardware.DcMotor
import com.qualcomm.robotcore.hardware.DcMotorSimple
import com.qualcomm.robotcore.hardware.HardwareMap
import kotlin.math.abs
import kotlin.math.cos
import kotlin.math.max
import kotlin.math.sin

class Robot(hardwareMap: HardwareMap) {
    val frontLeft = hardwareMap.dcMotor.get("front_left_drive")
    val frontRight = hardwareMap.dcMotor.get("front_right_drive")
    val backLeft = hardwareMap.dcMotor.get("back_left_drive")
    val backRight = hardwareMap.dcMotor.get("back_right_drive")

    val intake = hardwareMap.dcMotor.get("intake")
    val shooter = hardwareMap.dcMotor.get("shooter")

    init {
        // frontLeft.direction = DcMotorSimple.Direction.REVERSE
        // backLeft.direction = DcMotorSimple.Direction.REVERSE
        // frontRight.direction = DcMotorSimple.Direction.FORWARD
        // backRight.direction = DcMotorSimple.Direction.FORWARD

        frontLeft.direction = DcMotorSimple.Direction.FORWARD
        backLeft.direction = DcMotorSimple.Direction.FORWARD
        frontRight.direction = DcMotorSimple.Direction.FORWARD
        backRight.direction = DcMotorSimple.Direction.FORWARD

        for (motor in listOf(frontLeft, frontRight, backLeft, backRight)) {
            motor.zeroPowerBehavior = DcMotor.ZeroPowerBehavior.BRAKE
        }
    }
    






    /**
     * @param translationAngle direction to drive in radians, 0 = right, PI/2 = forward
     * @param translationPower how fast to drive, 0.0 to 1.0
     * @param turnPower how fast to turn, -1.0 to 1.0, positive = clockwise
     */
    val intakeMotor = hardwareMap.dcMotor.get("intake")

    fun setDrive(translationAngle: Double, translationPower: Double, turnPower: Double) {
        // calculate motor power for the diagonal wheel pairs
        // A/D = front left + back right, B/C = front right + back left
        var ADPower = sin(translationAngle) + cos(translationAngle)
        var BCPower = sin(translationAngle) - cos(translationAngle)

        // scale so the larger pair is at full power, otherwise driving straight forward only reaches ~70% power
        val translationScale = max(abs(ADPower), abs(BCPower))
        if (translationScale > 0.0) {
            ADPower = ADPower / translationScale * translationPower
            BCPower = BCPower / translationScale * translationPower
        }
        // check if turning power will interfere with normal translation
        // check ADPower to see if trying to apply turnPower would put motor power over 1.0 or under -1.0
        var turningScale = max(abs(ADPower + turnPower), abs(ADPower - turnPower))
        // check BCPower to see if trying to apply turnPower would put motor power over 1.0 or under -1.0
        turningScale = max(turningScale, max(abs(BCPower + turnPower), abs(BCPower - turnPower)))

        // adjust turn power scale correctly
        if (turningScale < 1.0) {
            turningScale = 1.0
        }

        // set the motors, and divide them by turningScale to make sure none of them go over the top, which would alter the translation angle
        frontLeft.power = (ADPower + turnPower) / turningScale
        backLeft.power = (BCPower + turnPower) / turningScale
        frontRight.power = (BCPower - turnPower) / turningScale
        backRight.power = (ADPower - turnPower) / turningScale
    }

    fun intakeTrigger(Power: Double) {
        intake.power = Power
    }
    fun releaseBalls() {
        intake.power = -0.1
    }
}
