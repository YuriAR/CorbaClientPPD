import CoordinatorResourceCommunication.CoordinatorInterface;
import CoordinatorResourceCommunication.CoordinatorInterfaceHelper;
import org.omg.CORBA.ORB;
import org.omg.CosNaming.NameComponent;
import org.omg.CosNaming.NamingContext;
import org.omg.CosNaming.NamingContextHelper;

/**
 * Created by yurir on 26/01/2017.
 */
public class CorbaManager {

    CoordinatorInterface coordinator;
    String myPid;
    ORB orb;


    public CorbaManager(String pId){
        this.myPid = pId;
    }

    public void initCorba(String [] args){
        try{

            orb = ORB.init(args,null);
            org.omg.CORBA.Object obj = orb.resolve_initial_references("NameService");

            NamingContext naming = NamingContextHelper.narrow(obj);

            NameComponent[] name = {new NameComponent("Coordinator","Exemplo")};

            org.omg.CORBA.Object objRef =  naming.resolve(name);

            coordinator = CoordinatorInterfaceHelper.narrow(objRef);

        }catch (Exception e) {
            System.out.println("Outro Erro : " + e);
            e.printStackTrace(System.out);
        }
    }

    public void requestResource(){
        coordinator.requestResource(myPid);
    }

    public void releaseResource(){
        coordinator.releaseResource();
    }

}
