import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable{
    @FXML
    Label processId;
    @FXML
    Label processStatus;
    @FXML
    Button buttonRequest;
    @FXML
    Button buttonRelease;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //alert pedindo porta

            buttonRequest.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    //Enviar request
                    //Change status
                }
            });

            buttonRelease.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    //Enviar release
                    //Change status
                }
            });

    }
}
