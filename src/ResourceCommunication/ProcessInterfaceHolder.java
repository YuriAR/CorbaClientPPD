package ResourceCommunication;

/**
* ResourceCommunication/ProcessInterfaceHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from ResourceCommunication.idl
* Quinta-feira, 26 de Janeiro de 2017 12h28min05s GFT
*/

public final class ProcessInterfaceHolder implements org.omg.CORBA.portable.Streamable
{
  public ResourceCommunication.ProcessInterface value = null;

  public ProcessInterfaceHolder ()
  {
  }

  public ProcessInterfaceHolder (ResourceCommunication.ProcessInterface initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = ResourceCommunication.ProcessInterfaceHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    ResourceCommunication.ProcessInterfaceHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return ResourceCommunication.ProcessInterfaceHelper.type ();
  }

}