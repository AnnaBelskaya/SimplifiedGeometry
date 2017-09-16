package foryuriy;

import javafx.application.Platform;
import javafx.scene.shape.Rectangle;

public class RectangleRunnable implements Runnable {
    private boolean direction = true;
    private Rectangle rectangle;

    public RectangleRunnable(Rectangle rectangle) {
        this.rectangle = rectangle;
    }

    @Override
    public void run() {
        while (App00.isActive) {
            double x = rectangle.getTranslateX();

            if (x+1 + rectangle.getWidth() >= 400) direction = false;

            if (x-1 <= 0) direction = true;

            if (direction) x++;
            else x--;

            final double X = x;

            Platform.runLater(()->
                rectangle.setTranslateX(X));

            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}