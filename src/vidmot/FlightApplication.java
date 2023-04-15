package src.vidmot;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class FlightApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(
            FlightApplication.class.getResource("search.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 600, 400);
        stage.setTitle("Flight Booking");
        stage.setScene(scene);
        stage.show();   // birta gluggann
    }

    public static void main(String[] args) {
        launch();
    }

}
