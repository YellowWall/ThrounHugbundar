package hi.verkefni.vidmot;

import hi.verkefni.repositories.BookingRepository;
import hi.verkefni.vinnsla.Flight;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

public class SearchController {
    public TextField flugnum;
    private Stage stage;
    private Scene scene;
    private Parent root;
    public ArrayList<Flight> flights = null;

    public void switchToSceneInfo(ActionEvent actionEvent) throws IOException {
        flights = new BookingRepository().getFlightsByFlightNum(flugnum.getText());
        System.out.println(flights);
        Iterator<Flight> it = flights.iterator();
        while (it.hasNext()){
            System.out.println(it.next().getFlightNo());
        }
        FXMLLoader loader  = new FXMLLoader();
        loader.setLocation(getClass().getResource("flightInfo.fxml"));
        //root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("flightInfo.fxml")));
        loader.load();
        FlightInfoController cont =loader.getController();
        cont.setFlights(flights);
        root = loader.getRoot();
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene((root));
        stage.setTitle("Flight Info");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneSearch(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("search.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene((root));
        stage.setTitle("Flight Search");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSceneCompleted(ActionEvent actionEvent) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("completed.fxml")));
        stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        scene = new Scene((root));
        stage.setTitle("Booking completed");
        stage.setScene(scene);
        stage.show();
    }
}
