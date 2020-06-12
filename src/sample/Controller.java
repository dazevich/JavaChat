package sample;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.TilePane;

public class Controller {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TilePane dialogsPlace;

    @FXML
    private TilePane messagePlace;

    @FXML
    private Button messageSend;

    @FXML
    private TextField messageText;

    @FXML
    void initialize() {


    }
}
