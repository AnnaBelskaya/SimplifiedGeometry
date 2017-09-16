import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;

class MyCircle{
   private Circle circle;
   private double radius;
   private Random r = new Random();

    public MyCircle() throws InterruptedException {
        setCircle();
    }

    private void setCircle(){
        radius = r.nextInt(40) + 10;
        circle = new Circle(radius);
        circle.setFill(Paint.valueOf(Color.color(
                r.nextDouble(),
                r.nextDouble(),
                r.nextDouble()).toString()));
        circle.setTranslateX(r.nextInt(100) + radius);
        circle.setTranslateY(r.nextInt(300) + radius);
    }

    public void action(double x, double y) {
        while (Main.isActive) {
            //collide
            if (circle.getTranslateX() + x + radius * 2 >= Main.W ||
                    circle.getTranslateX() + x <= radius)
                x = -x;
            if (circle.getTranslateY() + y >= Main.H - radius * 2 ||
                    circle.getTranslateY() + y <= radius)
                y = -y;

            final double X = circle.getTranslateX() + x;
            final double Y = circle.getTranslateY() + y;

            Platform.runLater(() -> {
                circle.setTranslateX(X);
                circle.setTranslateY(Y);
            });

            try {
                Thread.sleep(r.nextInt(30) + 10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public Circle getCircle() {
        return circle;
    }
}