package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "DrivingProgram (Blocks to Java)")
public class DrivingProgram extends LinearOpMode {

  private DcMotor leftmotor0;
  private DcMotor topleftmotor2;
  private Servo drone5AsServo;
  private Servo ClawServo1AsServo;
  private DcMotor rightmotor1;
  private DcMotor toprightmotor3;
  private Servo ClawServo0AsServo;
  private DcMotor port2AsDcMotor;
  private DcMotor port0AsDcMotor;

  @Override
  public void runOpMode() {
    leftmotor0 = hardwareMap.get(DcMotor.class, "leftmotor0");
    topleftmotor2 = hardwareMap.get(DcMotor.class, "topleftmotor2");
    drone5AsServo = hardwareMap.get(Servo.class, "drone5AsServo");
    ClawServo1AsServo = hardwareMap.get(Servo.class, "ClawServo1AsServo");
    rightmotor1 = hardwareMap.get(DcMotor.class, "rightmotor1");
    toprightmotor3 = hardwareMap.get(DcMotor.class, "toprightmotor3");
    ClawServo0AsServo = hardwareMap.get(Servo.class, "ClawServo0AsServo");
    port2AsDcMotor = hardwareMap.get(DcMotor.class, "port2AsDcMotor");
    port0AsDcMotor = hardwareMap.get(DcMotor.class, "port0AsDcMotor");

    waitForStart();
    
    leftmotor0.setDirection(DcMotorSimple.Direction.REVERSE);
    topleftmotor2.setDirection(DcMotorSimple.Direction.REVERSE);
    drone5AsServo.setPosition(0.2);
    
    //CLAW THINGY MA BOBBER
    int monke = 0;
    
    while (opModeIsActive()) {
      forward();
      backward();
      turn();
      slyde();
      Arm();
      Linearact();
      finger();
      claw2();
      droneLaunch();
    }
  }


  private void droneLaunch() {
    if (gamepad1.a) {
      drone5AsServo.setPosition(-0.3);
    } else {
      drone5AsServo.setPosition(0.2);
    }
  }


  private void finger() {
    if (gamepad2.a) {
      ClawServo1AsServo.setPosition(0);
    } else if (gamepad2.b) {
      ClawServo1AsServo.setPosition(0.65);
    } else {
      ClawServo1AsServo.setPosition(0.5);
    }
  }


  private void backward() {
    rightmotor1.setPower(gamepad1.left_trigger * -1);
    leftmotor0.setPower(gamepad1.left_trigger * -0.9);
    topleftmotor2.setPower(gamepad1.left_trigger * -1);
    toprightmotor3.setPower(gamepad1.left_trigger * -0.9);
  }


  private void claw2() {
    if (gamepad2.x) {
      ClawServo0AsServo.setPosition(0);
    } else if (gamepad2.y) {
      ClawServo0AsServo.setPosition(0.57);
    } else {
      ClawServo0AsServo.setPosition(0.5);
    }
  }


  private void forward() {
    rightmotor1.setPower(gamepad1.right_trigger / 0.33333);
    leftmotor0.setPower(gamepad1.right_trigger / 0.1);
    topleftmotor2.setPower(gamepad1.right_trigger / 0.1);
    toprightmotor3.setPower(gamepad1.right_trigger / 0.33333);
  }


  private void slyde() {
    rightmotor1.setPower(gamepad1.right_stick_x * 0.7);
    leftmotor0.setPower(gamepad1.right_stick_x * -0.8);
    topleftmotor2.setPower(gamepad1.right_stick_x * -0.8);
    toprightmotor3.setPower(gamepad1.right_stick_x * 0.7);
  }


  private void Linearact() {
    port2AsDcMotor.setPower(gamepad2.right_stick_y * -1);
  }


  private void Arm() {
    port0AsDcMotor.setPower(gamepad2.left_stick_y * -0.5);
  }


  private void turn() {
    leftmotor0.setPower(gamepad1.left_stick_x * 0.8);
    topleftmotor2.setPower(gamepad1.left_stick_x * -0.8);
    toprightmotor3.setPower(gamepad1.left_stick_x * -0.7);
    rightmotor1.setPower(gamepad1.left_stick_x * 0.7);
  }
}
