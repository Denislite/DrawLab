package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {

        Canvas canvas = new Canvas(640.0f, 400.0f);
        GraphicsContext graphics_context = canvas.getGraphicsContext2D();

        //React
        graphics_context.setFill(Color.RED);
        graphics_context.fillRect(20, 20, 70, 70);

        //Oval or circle
        graphics_context.setFill(Color.BLUE);
        graphics_context.fillOval(100, 20, 70, 70);

        //Polygon
        double xpoints[] = {180,220,260,240,200};
        double ypoints[] = {55,90,55,20,20};
        int npoints = 5;
        graphics_context.setFill(Color.GREEN);
        graphics_context.fillPolygon(xpoints,ypoints,npoints);

        //Just a line
        graphics_context.strokeLine(20,100,90,170);

        //line with 5 heads
        double lxpoint[] = {100,120,140,160,180};
        double lypoint[] = {100,180,100,180,100};
        int lnpoints = 5;
        graphics_context.strokePolyline(lxpoint,lypoint,lnpoints);

        //Make a group of figures
        Group group = new Group(canvas);

        scene = new Scene(group, 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}