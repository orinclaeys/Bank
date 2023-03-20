package com.example.Bank.client;

import org.springframework.stereotype.Service;

import java.util.Vector;

public class ClientDatabase {
    private Vector<Client> clients = new Vector();
    private int size=0;
    private Boolean in_use=false;

    public ClientDatabase() {
        this.config();
    }

    public void config(){
        this.in_use=true;
        this.addClient(new Client(2000,"Vera",0,123456789));
        this.addClient(new Client(3000,"Ella",0,123789456));
        this.addClient(new Client(4000,"Alex",0,987654321));
        this.in_use=false;
    }

    public Vector<Client> getClients(){return clients;}
    public Client getClient(int id){
        this.in_use=true;
        Client client = null;
        for(int i=0;i<clients.size();i++){
            if(clients.elementAt(i).getID()==id){
                client=clients.elementAt(i);
            }
        }
        this.in_use=false;
        return client;
    }

    public void addClient(Client client){
        this.in_use=true;
        client.setID(size);
        size++;
        clients.add(client);
        System.out.println("client added");
        this.in_use=false;
    }

    public void deleteClient(int id){
        this.in_use=true;
        for(int i=0;i< clients.size();i++){
            if(clients.elementAt(i).getID()==id){
                clients.remove(i);
                System.out.println("Client deleted");
            }
        }
        this.in_use=false;
    }
    
    public Double getBalance(int id){
        this.in_use=true;
        double balance = 0;
        for(int i=0;i< clients.size();i++){
            if(clients.elementAt(i).getID()==id){
                balance=clients.elementAt(i).getBalance();
            }
        }
        this.in_use=false;
        return balance;
    }
    
    public void deposit(int id, Double amount){
        this.in_use=true;
        System.out.println("Depositing");
        for(int i=0;i< clients.size();i++){
            if(clients.elementAt(i).getID()==id){
                clients.elementAt(i).deposit(amount);
            }
        }
        this.in_use=false;
    }
    
    public void withdraw(int id, Double amount){
        this.in_use=true;
        for(int i=0;i< clients.size();i++){
            if(clients.elementAt(i).getID()==id){
                clients.elementAt(i).withdraw(amount);
            }
        }
        this.in_use=false;
    }
    
    public void transfer(int clientID,int receiverID,Double amount){
        this.in_use=true;
        Client sender = null;
        Client receiver = null;
        for(int i=0;i< clients.size();i++){
            if(clients.elementAt(i).getID()==clientID){
                sender=clients.elementAt(i);
            }
            if(clients.elementAt(i).getID()==receiverID){
                receiver=clients.elementAt(i);
            }
        }
        if(sender.getBalance()>=amount){
            sender.withdraw(amount);
            receiver.deposit(amount);
        }
        this.in_use=false;
    }

    public Boolean isInUse(){return this.in_use;}
}
