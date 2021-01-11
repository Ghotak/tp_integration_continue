package com.integrationcontinue.Repository;

import com.integrationcontinue.Bean.ClientWithProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientWithProductRepository extends JpaRepository<ClientWithProduct, Integer> {
}
