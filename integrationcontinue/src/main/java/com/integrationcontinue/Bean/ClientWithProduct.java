package com.integrationcontinue.Bean;

import com.integrationcontinue.Entity.Client;
import com.integrationcontinue.Entity.Product;

public class ClientWithProduct {
    private Client client;
    private Product product;

    public ClientWithProduct(){
        super();
    }
    public ClientWithProduct(Client client, Product product) {
        this.client = client;
        this.product = product;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
