import acm.program.GraphicsProgram;
import acm.graphics.*;
import java.awt.*;

public class Lab1Task2 extends GraphicsProgram {
    public static void main(String[] args){
        Lab1Task2 lab1Task2 = new Lab1Task2();
        lab1Task2.start();
    }
    // define necessary variables
    private static final int WORLD_WIDTH = 700;
    private static final int WORLD_HEIGHT = 600;
    private static final int NUMBER_OF_CIRCLES = 1;
    private static final int CIRCLE_RADIUS = 50;

    private static final double WIDTH_CENTER= (double) WORLD_WIDTH / 2;
    private static final double HEIGHT_CENTER= (double) WORLD_HEIGHT / 2;

    public void run() {
        this.setSize(WORLD_WIDTH, WORLD_HEIGHT);
        drawTheCircles();
    }

    // using for cycle to draw target(all circles)
    private void drawTheCircles() {
        double theBiggestRadius = (CIRCLE_RADIUS) * NUMBER_OF_CIRCLES;
        for (int i=0; i < (NUMBER_OF_CIRCLES); i++) {

            if (theBiggestRadius < WIDTH_CENTER && theBiggestRadius <= HEIGHT_CENTER)
                // checking if the screen parameters is okay
            {
                if (i % 2 != 0) {
                    drawCircle(WIDTH_CENTER, HEIGHT_CENTER, theBiggestRadius, Color.red);
                } else{
                    drawCircle(WIDTH_CENTER, HEIGHT_CENTER, theBiggestRadius, Color.pink);
                }
            }
            theBiggestRadius -= CIRCLE_RADIUS;
        }

    }

    // create method that draw circles in the right position with right radius

    private GOval drawCircle(double centerWidth, double centerHeight, double radius, Color color) {
        GOval circle = new GOval(centerWidth-radius, centerHeight-radius, 2*radius, 2*radius);
        circle.setFilled(true);
        circle.setColor(color);
        add(circle);
        return circle;
    }
}
