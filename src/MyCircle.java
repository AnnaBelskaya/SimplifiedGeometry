import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

import java.util.Random;

class MyCircle{
   private Circle circle;
   private Random r = new Random();
   private Thread thread;

    public MyCircle() throws InterruptedException {
        setCircle();
        setThread();
    }

    private void setCircle(){
        circle = new Circle();
        circle.setFill(Paint.valueOf(Color.color(
                r.nextDouble(),
                r.nextDouble(),
                r.nextDouble()).toString()));
        circle.setRadius(r.nextInt(40) + 10);
        circle.setTranslateX(r.nextInt(100) + circle.getRadius());
        circle.setTranslateY(r.nextInt(300) + circle.getRadius());
    }

    private void setThread() throws InterruptedException {
        thread = new Thread(()->{
            double x = 2;
            double y = 2;
            while(Main.isActive){
                if (circle.getTranslateX() + x >= Main.W - circle.getRadius()*2 ||
                        circle.getTranslateX() + x <= circle.getRadius())
                    x = -x;
                if (circle.getTranslateY() + y >= Main.H - circle.getRadius()*2 ||
                        circle.getTranslateY() + y <= circle.getRadius())
                    y = -y;

                circle.setTranslateX(circle.getTranslateX() + x);
                circle.setTranslateY(circle.getTranslateY() + y);
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                        e.printStackTrace();
                }
            }
        });
    }

    public void move(){
        thread.start();
    }

    public Circle getCircle() {
        return circle;
    }
}