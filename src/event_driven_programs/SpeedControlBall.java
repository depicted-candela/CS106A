package event_driven_programs;

import acm.program.*;
import acm.graphics.*;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SpeedControlBall extends GraphicsProgram {

    private static final long serialVersionUID = -599850683386731657L;

    private static final int DIAM_BALL = 30;
    private static final double X_START = DIAM_BALL / 2;
    private static final double Y_START = 100;
    private static final double X_VEL = 5;
    private static final double BOUNCE_REDUCE = 0.7;

    private JButton startButton;
    private JButton stopButton;
    private JSlider sizeSlider;
    private GOval ball;
    private boolean isRunning = false;

    private double xVel = X_VEL;
    private double yVel = 0.0;

    public void init() {
        add(startButton = new JButton("Start"), SOUTH);
        add(stopButton = new JButton("Stop"), SOUTH);
        add(new JLabel("Slow"), SOUTH);
        sizeSlider = new JSlider(0, 10, 9);
        add(new JLabel("Fast"), SOUTH);
        add(sizeSlider, SOUTH);

        addActionListeners();
        sizeSlider.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                int sliderValue = sizeSlider.getValue();
                double newGravity = sliderValue * 0.5; // Adjust this scaling factor as needed
                setGravity(newGravity);
            }
        });
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Start")) {
            startAnimation();
        } else if (e.getActionCommand().equals("Stop")) {
            stopAnimation();
        }
    }

    private void startAnimation() {
        if (!isRunning) {
            setup();
            isRunning = true;
            while (ball.getX() < getWidth() && isRunning) {
                moveBall();
                checkForCollision();
                pause(50);
            }
        }
    }

    private void stopAnimation() {
        isRunning = false;
    }

    private void setup() {
        if (ball != null) {
            remove(ball);
        }
        ball = new GOval(X_START, Y_START, DIAM_BALL, DIAM_BALL);
        ball.setFilled(true);
        add(ball);
    }

    private void moveBall() {
        yVel += GRAVITY;
        ball.move(xVel, yVel);
    }

    private void checkForCollision() {
        if (ball.getY() > getHeight() - DIAM_BALL) {
            yVel = -yVel * BOUNCE_REDUCE;
            double diff = ball.getY() - (getHeight() - DIAM_BALL);
            ball.move(0, -2 * diff);
        }
    }

    private void setGravity(double newGravity) {
        GRAVITY = newGravity;
    }

    public static void main(String[] args) {
        new SpeedControlBall().start();
    }

    private double GRAVITY = 3;
}
