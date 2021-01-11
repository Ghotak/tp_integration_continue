package com.integrationcontinue.Service;

import com.integrationcontinue.Bean.ClientWithProduct;
import com.integrationcontinue.Repository.ClientWithProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientWithProductService
{
    @Autowired
    private ClientWithProductRepository repo;

    public List<ClientWithProduct> listAll(){
        return repo.findAll();
    }

    public ClientWithProduct get(Integer id){
        return repo.findById(id).get();
    }
}
