package foryuriy;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.shape.Rectangle;
import java.util.List;

public class App00 extends Application {
    public static boolean isActive = true;

    @Override
    public void start(Stage myStage) {
        List<Rectangle> rectangles = new MyRectangle().getRectangles();

        myStage.setTitle("Multy Threads");
        Pane rootNode = new Pane();
        Scene myScene = new Scene(rootNode, 500, 500);
        myStage.setScene(myScene);

        rootNode.getChildren().addAll(rectangles);

        Button multyThreads = new Button("Multy Threads");
        multyThreads.setOnAction(event -> {
            for (int i = 0; i < rectangles.size(); i++){
                new Thread(new RectangleRunnable(rectangles.get(i))).start();
                multyThreads.setDisable(true);
            }
        });
        rootNode.getChildren().add(multyThreads);

        myStage.show();
    }

    public static void main(String[] args) { launch(args); }

    @Override
    public void stop() throws Exception {
        super.stop();
        isActive = false;
    }
}