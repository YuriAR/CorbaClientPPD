package ResourceCommunication;


/**
* ResourceCommunication/CoordinatorInterfacePOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ResourceCommunication.idl
* Quinta-feira, 26 de Janeiro de 2017 12h28min05s GFT
*/

public abstract class CoordinatorInterfacePOA extends org.omg.PortableServer.Servant
 implements ResourceCommunication.CoordinatorInterfaceOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("requestResource", new java.lang.Integer (0));
    _methods.put ("releaseResource", new java.lang.Integer (1));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // ResourceCommunication/CoordinatorInterface/requestResource
       {
         String pId = in.read_string ();
         this.requestResource (pId);
         out = $rh.createReply();
         break;
       }

       case 1:  // ResourceCommunication/CoordinatorInterface/releaseResource
       {
         this.releaseResource ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:ResourceCommunication/CoordinatorInterface:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public CoordinatorInterface _this() 
  {
    return CoordinatorInterfaceHelper.narrow(
    super._this_object());
  }

  public CoordinatorInterface _this(org.omg.CORBA.ORB orb) 
  {
    return CoordinatorInterfaceHelper.narrow(
    super._this_object(orb));
  }


} // class CoordinatorInterfacePOA
