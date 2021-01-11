package com.integrationcontinue.Service;

import com.integrationcontinue.Entity.Client;
import com.integrationcontinue.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientService {
    @Autowired
    private ClientRepository repo;

    public List<Client> listAll(){
        return repo.findAll();
    }

    public Client get(Integer id){
        return repo.findById(id).get();
    }
}
