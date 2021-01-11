package com.integrationcontinue.Service;

import com.integrationcontinue.Entity.Product;
import com.integrationcontinue.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository repo;

    public List<Product> listAll(){
        return repo.findAll();
    }

    public Product get(Integer id){
        return repo.findById(id).get();
    }

    //TODO dans class produit appliquerReduction(contrat)
    //identifiant du contrat
    //identifiant du produit
}
