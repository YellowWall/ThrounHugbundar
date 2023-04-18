package hi.verkefni.vidmot;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class FlightInfoController {
    private Stage stage;
    private Scene scene;
    private Parent root;

    public void switchToSceneSearch(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("Search.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene((root));
        stage.setTitle("Flight Search");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneRegistration(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registration.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene((root));
        stage.setTitle("Flight Registration");
        stage.setScene(scene);
        stage.show();
    }

    //Class.forName("com.mysql.cj.jdbc.Driver");
    //Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/mydatabase", "username", "password");
    //Statement stmt = conn.createStatement();
    //String query = "SELECT flight_number FROM flights";
    //ResultSet rs = stmt.executeQuery(query);
    //while(rs.next())

    //{
    //    int flightNumber = rs.getString("flight_number");
    // Do something with the flight number
    //}
    //rs.close();
    //stmt.close();
    //conn.close();


}

