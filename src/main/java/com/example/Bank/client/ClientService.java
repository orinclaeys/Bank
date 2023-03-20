package com.example.Bank.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientService extends Thread{
    private ClientDatabase clientDatabase;
    @Autowired
    public ClientService(){}
    public void setClientDatabase(ClientDatabase clientDatabase){
        this.clientDatabase=clientDatabase;
    }

    public List<Client> getClients(){
        while(clientDatabase.isInUse()){}
        return clientDatabase.getClients();
    }
    public void addClient(Client client){
        while(clientDatabase.isInUse()){}
        clientDatabase.addClient(client);
    }
    public void deleteClient(int id){
        while(clientDatabase.isInUse()){}
        clientDatabase.deleteClient(id);
    }
    public Double getBalance(int id){
        while(clientDatabase.isInUse()){}
        return clientDatabase.getBalance(id);
    }
    public void deposit(int id, Double amount){
        while(clientDatabase.isInUse()){}
        clientDatabase.deposit(id,amount);
    }
    public void withdraw(int id, Double amount){
        while(clientDatabase.isInUse()){}
        clientDatabase.withdraw(id,amount);
    }
    public void transfer(int clientID, int receiverID, Double amount){
        while(clientDatabase.isInUse()){}
        clientDatabase.transfer(clientID,receiverID,amount);
    }
}
