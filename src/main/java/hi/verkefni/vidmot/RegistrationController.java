package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class RegistrationController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToSceneCompleted(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("completed.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene((root));
        stage.setTitle("Booking complete");
        stage.setScene(scene);
        stage.show();
    }

}

