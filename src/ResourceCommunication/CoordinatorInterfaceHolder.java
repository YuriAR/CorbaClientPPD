package ResourceCommunication;

/**
* ResourceCommunication/CoordinatorInterfaceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ResourceCommunication.idl
* Quinta-feira, 26 de Janeiro de 2017 12h28min05s GFT
*/

public final class CoordinatorInterfaceHolder implements org.omg.CORBA.portable.Streamable
{
  public ResourceCommunication.CoordinatorInterface value = null;

  public CoordinatorInterfaceHolder ()
  {
  }

  public CoordinatorInterfaceHolder (ResourceCommunication.CoordinatorInterface initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ResourceCommunication.CoordinatorInterfaceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ResourceCommunication.CoordinatorInterfaceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ResourceCommunication.CoordinatorInterfaceHelper.type ();
  }

}