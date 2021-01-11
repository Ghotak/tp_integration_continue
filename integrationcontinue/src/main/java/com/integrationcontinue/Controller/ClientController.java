package com.integrationcontinue.Controller;

import com.integrationcontinue.Entity.Client;
import com.integrationcontinue.Service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ClientController {

    @Autowired
    private ClientService service;

    @GetMapping("/clients")
    public List<Client> list(){
        return service.listAll();
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity<Client> get(@PathVariable Integer id){
        try{
            Client client = service.get(id);
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        } catch(NoSuchElementException e) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }

}
