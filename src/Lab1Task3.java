import acm.program.GraphicsProgram;
import acm.graphics.*;
import java.awt.Color;
import java.awt.Font;
public class Lab1Task3 extends GraphicsProgram {
    public static void main(String[] args){
        Lab1Task3 lab1Task3 = new Lab1Task3();
        lab1Task3.start();
    }
    private static final int WIDTH_WORLD = 200;
    private static final int HEIGHT_WORLD = 200;

    // calculate variable using in the program
    int HEIGHT_CENTER = HEIGHT_WORLD / 2;
    int WIDTH_CENTER = WIDTH_WORLD / 2;
    int WIDTH_BLOCK = WIDTH_WORLD / 5;
    int HEIGHT_BLOCK = HEIGHT_WORLD / 10;
    int BLOCK_DISTANCE = WIDTH_WORLD / 20;

    private double size,textSize;

    public void run() {

        this.setSize(WIDTH_WORLD, HEIGHT_WORLD);
        size = chooseFontSize(HEIGHT_BLOCK, WIDTH_BLOCK - 20, new GLabel("GraphicsProgram",0,0));
        lines();
        rects();
        drawText();
        println(getWidth());
        println(getHeight());
    }

    // method that draw all lines
    private void lines() {

        GLine center_line = new GLine(WIDTH_CENTER,HEIGHT_CENTER - HEIGHT_BLOCK , WIDTH_CENTER, HEIGHT_CENTER);
        add(center_line);

        GLine left_line = new GLine(WIDTH_CENTER,HEIGHT_CENTER - HEIGHT_BLOCK, WIDTH_CENTER - (1 * WIDTH_BLOCK) - BLOCK_DISTANCE, HEIGHT_CENTER);
        add(left_line);

        GLine right_line = new GLine(WIDTH_CENTER,HEIGHT_CENTER - HEIGHT_BLOCK, WIDTH_CENTER + (1 * WIDTH_BLOCK) + BLOCK_DISTANCE, HEIGHT_CENTER);
        add(right_line);


    }

    // method that draw all rectangles
    private void rects() {
        GRect Program = new GRect(WIDTH_CENTER - WIDTH_BLOCK/2, HEIGHT_CENTER - 2 * HEIGHT_BLOCK, WIDTH_BLOCK, HEIGHT_BLOCK);
        add(Program);

        GRect ConsoleProgram = new GRect(WIDTH_CENTER - WIDTH_BLOCK/2, HEIGHT_CENTER , WIDTH_BLOCK, HEIGHT_BLOCK);
        add(ConsoleProgram);

        GRect GraphicsProgram = new GRect(WIDTH_CENTER - (1.5 * WIDTH_BLOCK) - BLOCK_DISTANCE, HEIGHT_CENTER, WIDTH_BLOCK, HEIGHT_BLOCK);
        add(GraphicsProgram);

        GRect DialogProgram = new GRect(WIDTH_CENTER +(0.5 * WIDTH_BLOCK) + BLOCK_DISTANCE, HEIGHT_CENTER, WIDTH_BLOCK, HEIGHT_BLOCK);
        add(DialogProgram);
    }

    // draw all text using the couple of additional methods below
    private void drawText() {
        // search for word "Program" length to center
        textSize = calculateTextSize("Program");
        drawBlankText("Program",WIDTH_CENTER - textSize/2,HEIGHT_CENTER - (HEIGHT_BLOCK * 1.5));

        textSize = calculateTextSize("GraphicsProgram");
        drawBlankText("GraphicsProgram",WIDTH_CENTER - (WIDTH_BLOCK*1.5) - BLOCK_DISTANCE,HEIGHT_CENTER + (HEIGHT_BLOCK * 0.5));

        textSize = calculateTextSize("ConsoleProgram");
        drawBlankText("ConsoleProgram",WIDTH_CENTER + (WIDTH_BLOCK*0.5) + BLOCK_DISTANCE,HEIGHT_CENTER + (HEIGHT_BLOCK * 0.5));

        textSize = calculateTextSize("DialogProgram");
        drawBlankText("DialogProgram",WIDTH_CENTER - textSize/2,HEIGHT_CENTER + (HEIGHT_BLOCK * 0.5));

    }
    // method that generate text
    private GLabel drawBlankText(String text2, double x, double y) {
        GLabel text = new GLabel(text2, x, y);
        text.setColor(Color.BLACK);
        text.setFont(setFontText(size));
        add(text);
        return text;
    }

    // set the font of text
    private Font setFontText(double textSixe) {
        return new Font("TimesRoman", Font.PLAIN, (int) textSixe);
    }

    // font size search
    private double chooseFontSize(double height, double width, GLabel text) {
        size = 0;
        text.setFont(setFontText(size));
        while(height > text.getHeight() && width > text.getWidth()) {
            size++;
            text.setFont(setFontText(size));
        }
        return size--;
    }

    // word length search
    private double calculateTextSize(String text) {
        GLabel text2 = new GLabel(text);
        text2.setFont(setFontText(size));
        return text2.getWidth();
    }

}

