import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;
import org.omg.PortableServer.POA;
import org.omg.PortableServer.POAHelper;

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
        //TODO: alert pedindo porta

        buttonRelease.setDisable(true);
        final CorbaManager manager = new CorbaManager("1");
        manager.initCorba(new String[] {"localhost", "1515"});

        try{
            ORB orb = ORB.init(new String[] {"localhost", "1515"},null);
            org.omg.CORBA.Object objPoa = orb.resolve_initial_references("RootPOA");
            POA rootPOA = POAHelper.narrow(objPoa);
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");
            NamingContext naming = NamingContextHelper.narrow(obj);
            ProcessInterfaceImpl processInterface = new ProcessInterfaceImpl(this);
            org.omg.CORBA.Object   objRef =	 rootPOA.servant_to_reference(processInterface);
            NameComponent[] name = {new NameComponent("Processo" + manager.myPid,"Exemplo")};
            naming.rebind(name,objRef);
            rootPOA.the_POAManager().activate();
            processStatus.setText("Processo pronto");
            orb.run();

        }catch (Exception ex){
            System.out.println("Erro");
            ex.printStackTrace();
        }

        buttonRequest.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    //Enviar request
                    buttonRequest.setDisable(true);
                    processStatus.setText("Aguardando recurso");
                    manager.requestResource();
                }
            });

            buttonRelease.setOnMouseClicked(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    //Enviar release
                    buttonRelease.setDisable(true);
                    processStatus.setText("IDLE");
                    manager.releaseResource();
                }
            });

    }

    @Override
    public void onResourceConceded() {
        buttonRelease.setDisable(false);
        processStatus.setText("Usando recurso");
    }
}
