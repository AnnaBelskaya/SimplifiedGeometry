package foryuriy;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MyRectangle {
    private Random r = new Random();
    private List<Rectangle> rectangles = new ArrayList<>();

    public MyRectangle() { }

    private Rectangle generateRectangle(){
        int width = r.nextInt(100) + 10;
        int height = r.nextInt(100) + 10;
        int x = r.nextInt(200) + width;
        int y = r.nextInt(200) + height;
        Rectangle rectangle = new Rectangle(x,y,width,height);
        rectangle.setFill(Color.color(r.nextDouble(),
                r.nextDouble(),
                r.nextDouble()));
        return rectangle;
    }

    public List<Rectangle> getRectangles() {
        int number = r.nextInt(5) + 1;
        for (int i = 0; i < number; i++){
            rectangles.add(generateRectangle());
        }
        return rectangles;
    }
}
