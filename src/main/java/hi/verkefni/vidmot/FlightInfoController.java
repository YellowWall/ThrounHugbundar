package hi.verkefni.vidmot;

import hi.verkefni.vinnsla.Flight;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class FlightInfoController {
    private Stage stage;
    private Scene scene;
    private Parent root;
    private ArrayList<Flight> flights = null;
    public Text text;


    public void switchToSceneRegistration(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("registration.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene((root));
        stage.setTitle("Flight Registration");
        stage.setScene(scene);
        stage.show();
    }
    public void setFlights(ArrayList<Flight> flight){
        this.flights = flight;
        Iterator<Flight> it = this.flights.iterator();
        while(it.hasNext()){
            text.setText(it.next().getFlightNo());
        }
        System.out.println("kominn í setflights");
    }

}

