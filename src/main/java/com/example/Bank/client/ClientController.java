package com.example.Bank.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="api/v1/client")
public class ClientController {
    private final ClientDatabase clientDatabase = new ClientDatabase();
    @Autowired
    public ClientController() {}

    @GetMapping
    public List<Client> getClients(){
        ClientService clientService = new ClientService();
        clientService.setClientDatabase(this.clientDatabase);
        return clientService.getClients();
    }

    @PostMapping
    public void addNewClient(@RequestBody Client client){
        System.out.println(client);
        ClientService clientService = new ClientService();
        clientService.setClientDatabase(this.clientDatabase);
        clientService.addClient(client);
    }

    @DeleteMapping(path="{clientID}")
    public void deleteStudent(@PathVariable("clientID") int id){
        ClientService clientService = new ClientService();
        clientService.setClientDatabase(this.clientDatabase);
        clientService.deleteClient(id);
    }

    @GetMapping(path = "{clientID}/balance")
    public double getBalance(@PathVariable("clientID") int id){
        ClientService clientService = new ClientService();
        clientService.setClientDatabase(this.clientDatabase);
        return clientService.getBalance(id);
    }

    @PutMapping(path="{clientID}/deposit/{amount}")
    public void deposit(@PathVariable("clientID") int clientID, @PathVariable("amount") double amount){
        ClientService clientService = new ClientService();
        clientService.setClientDatabase(this.clientDatabase);
        clientService.deposit(clientID,amount);
    }

    @PutMapping(path="{clientID}/withdraw/{amount}")
    public void withdraw(@PathVariable int clientID,@PathVariable Double amount){
        ClientService clientService = new ClientService();
        clientService.setClientDatabase(this.clientDatabase);
        clientService.withdraw(clientID,amount);
    }

    @PutMapping(path="{clientID}/transfer/{receiverID}/{amount}")
    public void transfer(@PathVariable int clientID,@PathVariable int receiverID,@PathVariable Double amount){
        ClientService clientService = new ClientService();
        clientService.setClientDatabase(this.clientDatabase);
        clientService.transfer(clientID,receiverID,amount);
    }

}
