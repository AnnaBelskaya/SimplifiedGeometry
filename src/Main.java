import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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

        int n = 3;
        MyCircle[] myCircle = new MyCircle[n];
        for (int i = 0; i < n; i++) {
            myCircle[i] = new MyCircle();
            root.getChildren().add(myCircle[i].getCircle());
            myCircle[i].move();
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