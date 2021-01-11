package com.integrationcontinue.Controller;

import com.integrationcontinue.Bean.ClientWithProduct;
import com.integrationcontinue.Entity.Product;
import com.integrationcontinue.Service.ClientWithProductService;
import com.integrationcontinue.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
public class ProductController {

    @Autowired
    private ProductService serviceProduit;

    @Autowired
    private ClientWithProductService serviceClientWithProduct;

    @GetMapping("/products")
    public List<Product> list(){
        return serviceProduit.listAll();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> get(@PathVariable Integer id){
        try{
            Product product = serviceProduit.get(id);
            return new ResponseEntity<Product>(product, HttpStatus.OK);
        } catch(NoSuchElementException e) {
            return new ResponseEntity<Product>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("")
    public ResponseEntity<ClientWithProduct> getClientWithProduct(@PathVariable Integer idClient){
        try{
            ClientWithProduct clientWithProduct = serviceClientWithProduct.get(idClient);
            return new ResponseEntity<ClientWithProduct>(clientWithProduct, HttpStatus.OK);
        } catch(NoSuchElementException e) {
            return new ResponseEntity<ClientWithProduct>(HttpStatus.NOT_FOUND);
        }
    }
}
