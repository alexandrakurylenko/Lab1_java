import acm.program.GraphicsProgram;
import acm.graphics.*;
import java.awt.*;

public class Lab1Task1 extends GraphicsProgram {
        // Let`s announce the constants
        private static final int WORLD_WIDTH = 600;
        private static final int WORLD_HEIGHT = 700;
        private static final int BRICK_WIDTH = 80;
        private static final int BRICK_HEIGHT = 50;
        private static final int BRICKS_IN_BASE = 7;
        // Center of the window
        private static final double CENTER = (double)WORLD_WIDTH / 2;

        public void run(){
            this.setSize(WORLD_WIDTH, WORLD_HEIGHT);
            Pyramid();
        }

        // The main method draws a pyramid
        private void Pyramid() {
            int bricksN = BRICKS_IN_BASE;
            double startX;
            double startY = (WORLD_HEIGHT-80) - BRICK_HEIGHT;
            for (int i = BRICKS_IN_BASE; i > 0; i--) {
                startX = CENTER - ((bricksN * BRICK_WIDTH) / 2);
                for (int j = bricksN; j > 0; j--) {
                    drawBrick(startX, startY, BRICK_WIDTH, BRICK_HEIGHT, Color.BLACK);
                    startX += BRICK_WIDTH;
                }
                bricksN --;
                startY -= BRICK_HEIGHT;
            }
        }

        // This method draws a brick
        private GRect drawBrick(double startx, double starty, int width, int height, Color color) {
            GRect brick = new GRect(startx, starty, width, height);
            brick.setColor(color);
            add(brick);
            return brick;
        }
    }
