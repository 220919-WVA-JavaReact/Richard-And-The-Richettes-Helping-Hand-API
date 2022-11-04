package com.revature.helpinghandapi.repositories;


import com.revature.helpinghandapi.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Optional<Client> getClientByUsername(String username);

    Optional<Client> getClientByUsernameAndPassword(String username, String password);
}
