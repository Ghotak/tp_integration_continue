package com.integrationcontinue.Repository;

import com.integrationcontinue.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {
}
