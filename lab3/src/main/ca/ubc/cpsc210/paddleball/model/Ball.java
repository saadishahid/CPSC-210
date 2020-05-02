package ca.ubc.cpsc210.paddleball.model;

import java.awt.Color;
import java.awt.Rectangle;

/*
 * Represents a ball.
 */
public class Ball {
    public static final int SIZE = 20;  // must be even integer
    public static final Color COLOR = new Color(10, 50, 188);

    private double x1;
    private double y1;
    private double deltaX;
    private double deltaY;

    // Constructs an ball
    // EFFECTS: ball is positioned at coordinates (x, y) with velocity (2.0, 2.0)
    public Ball(int x, int y) {
        this.x1 = x;
        this.y1 = y;
        deltaX = 2.0;
        deltaY = 2.0;
    }

    public int getX() {
        return (int) x1;
    }

    public int getY() {
        return (int) y1;
    }

    public double getDx() {
        return deltaX;
    }

    public double getDy() {
        return deltaY;
    }

    // Bounce ball off paddle
    // MODIFIES: this
    // EFFECTS: vertical component of ball's velocity is reversed
    public void bounceOffPaddle() {
        deltaY *= -1;
    }

    // Updates ball on clock tick
    // MODIFIES: this
    // EFFECTS:  ball is moved (dx, dy) units
    public void move() {
        x1 = x1 + deltaX;
        y1 = y1 + deltaY;

        deal_with_it();
    }

    // Determines if this ball has collided with the paddle
    // EFFECTS:  returns true if this ball has collided with paddle p,
    //           false otherwise
    public boolean doSomething(Puddle p) {
        Rectangle ballBoundingRectangle = new Rectangle(getX() - SIZE / 2, getY() - SIZE / 2, SIZE, SIZE);
        Rectangle paddleBoundingRectangle = new Rectangle(p.getX() - Puddle.DIMENSION1 / 2,
                Puddle.Y_POS - Puddle.DIMENSION2 / 2, Puddle.DIMENSION1, Puddle.DIMENSION2);
        return ballBoundingRectangle.intersects(paddleBoundingRectangle);
    }

    // Constrains ball so that it bounces off top and vertical walls
    // MODIFIES: this
    // EFFECTS: ball is constrained to bounce off top and vertical walls
    private void deal_with_it() {
        if (getX() - SIZE / 2 < 0) {
            x1 = SIZE / 2;
            deltaX *= -1;
        } else if (getX() + SIZE / 2 > PBG.DIMENSION1) {
            x1 = PBG.DIMENSION1 - SIZE / 2;
            deltaX *= -1;
        } else if (getY() - SIZE / 2 < 0) {
            y1 = SIZE / 2;
            deltaY *= -1;
        }
    }
}
