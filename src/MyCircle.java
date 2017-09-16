import javafx.application.Platform;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;

class MyCircle{
   private Circle circle;
   private double x, y, radius;
   private Random r = new Random();

    public MyCircle() throws InterruptedException {
        setCircle();
    }

    private void setCircle(){
        radius = r.nextInt(40) + 10;
        x = r.nextInt(100) + radius;
        y = r.nextInt(300) + radius;
        circle = new Circle(radius);
        circle.setFill(Paint.valueOf(Color.color(
                r.nextDouble(),
                r.nextDouble(),
                r.nextDouble()).toString()));
        circle.setTranslateX(x);
        circle.setTranslateY(y);
    }

    public void action(double a, double b) {
        while (Main.isActive) {
            //bounce
            if (x + a + radius * 2 >= Main.W ||
                    x + a <= radius)
                a = -a;
            if (y + b >= Main.H - radius * 2 ||
                    y + b <= radius)
                b = -b;

            y+=b;
            x+=a;

            Platform.runLater(() -> {
                circle.setTranslateX(x);
                circle.setTranslateY(y);
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