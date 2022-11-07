package com.revature.helpinghandapi.repositories;

import com.revature.helpinghandapi.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, String> {
}
