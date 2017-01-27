import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable, UICommunication{
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
        buttonRelease.setDisable(true);
        ProcessInterfaceImpl processInterface = new ProcessInterfaceImpl(this);
        //alert pedindo porta

            buttonRequest.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    //Enviar request
                    buttonRequest.setDisable(true);
                    processStatus.setText("Aguardando recurso");
                }
            });

            buttonRelease.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    //Enviar release
                    buttonRelease.setDisable(true);
                    processStatus.setText("IDLE");
                }
            });

    }

    @Override
    public void onResourceConceded() {
        buttonRelease.setDisable(false);
        processStatus.setText("Usando recurso");
    }
}
