import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.util.Random;

public class Main extends Application{
    public static boolean isActive = true;
    public static final double W = 600;
    public static final double H = 400;

    @Override
    public void start(Stage stage) throws Exception {
        Pane root = new Pane();
        stage.setScene(new Scene(root));
        stage.setWidth(W);
        stage.setHeight(H);

        int n = 10;
        MyCircle[] myCircle = new MyCircle[n];
        Thread[] threads = new Thread[n];

        for (int i = 0; i < n; i++) {
            myCircle[i] = new MyCircle();
            final int index = i;
            final int X = new Random().nextInt(5) + 1;
            final int Y = new Random().nextInt(5) + 1;
            threads[i] = new Thread(()-> myCircle[index].action(X,Y));
            root.getChildren().add(myCircle[i].getCircle());
        }

        for (int i = 0; i < n; i++){
            threads[i].start();
        }

        stage.show();
    }

    @Override
    public void stop() throws Exception {
        isActive = false;
        super.stop();
    }

    public static void main(String[] args) {
        launch(args);
    }
}