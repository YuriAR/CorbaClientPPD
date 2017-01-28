import ProcessResourceCommunication.ProcessInterfacePOA;
import javafx.application.Platform;

/**
 * Created by yurir on 27/01/2017.
 */
public class ProcessInterfaceImpl extends ProcessInterfacePOA{

    UICommunication listener;

    public ProcessInterfaceImpl(UICommunication listener){
        this.listener = listener;
    }

    @Override
    public void concedeResource() {
        Platform.runLater(new Runnable(){
            @Override
            public void run() {
                listener.onResourceConceded();
            }
        });
    }
}
