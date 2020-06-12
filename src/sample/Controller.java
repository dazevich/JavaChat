package sample;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import com.sun.media.jfxmediaimpl.platform.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Background;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Controller {

    public static int msgCount = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TilePane dialogsPlace;

    @FXML
    private FlowPane messagePlace;

    @FXML
    private Button messageSend;

    @FXML
    private TextField messageText;

    @FXML
    private ScrollPane msgScrollBox;

    @FXML
    void sendMsgAction(ActionEvent event) {

        DropShadow shadow = new DropShadow();
        shadow.setColor(Color.web("#cccccc"));
        shadow.setRadius(5.0);
        shadow.setOffsetX(2);
        shadow.setOffsetY(2);

        if (!messageSend.getText().isEmpty()){
            msgScrollBox.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);

            messagePlace.setVgap(10);
            messagePlace.setAlignment(Pos.BOTTOM_LEFT);

            Text message = new Text(messageText.getText());
            Date dateNow = new Date();
            SimpleDateFormat date = new SimpleDateFormat("hh:mm");
            Text dateText = new Text(date.format(dateNow));
            dateText.setTextAlignment(TextAlignment.RIGHT);
            message.setWrappingWidth(120);

            TilePane msgTile = new TilePane();
            msgTile.setPrefSize(1000, 48);


            TilePane msgBox = new TilePane();
            msgBox.setPrefSize(140, 48);
            msgBox.setStyle("-fx-background-color: #FFFFFF; -fx-border-radius:25;");
            msgBox.setAlignment(Pos.CENTER);
            msgBox.getChildren().add(message);
            messageText.setText("");


            msgTile.setVgap(5);
            msgTile.getChildren().add(msgBox);
            msgTile.getChildren().add(dateText);
            msgTile.setEffect(shadow);

            messagePlace.getChildren().add(msgTile);
            msgScrollBox.setVvalue(1.0);
            messagePlace.heightProperty().addListener(observable -> msgScrollBox.setVvalue(1.0));
        }
    }

    @FXML
    void initialize() {


    }
}
