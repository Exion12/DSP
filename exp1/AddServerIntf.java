import java.rmi.Remote;
import java.rmi.RemoteException;

public interface AddServerIntf extends Remote{
    double add(double d1, double d2) throws RemoteException;
}

//client folder - addClient,AddServerImplstub,AddServerIntf
//Server folder -AddServer,AddServerImpl,AddServerImplStub,AddServerImtf
//exp1/ javac AddClient.java
//exp1/javac AddServer.java
//exp1/rmic AddServerImpl
//exp1/server/ rmiregistry

//open terminal 2
//exp1/server/ java AddServer

//open terminal 3
//exp1/client/ java AddClient 127.0.0.1 8 9
