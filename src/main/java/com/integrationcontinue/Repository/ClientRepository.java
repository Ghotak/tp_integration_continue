package com.integrationcontinue.Repository;

import com.integrationcontinue.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
