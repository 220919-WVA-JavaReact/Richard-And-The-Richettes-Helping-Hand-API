package com.revature.helpinghandapi.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.helpinghandapi.entities.Client;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<Client, String> {
    Optional<Client> getClientByUsername(String username);

    Optional<Client> getClientByUsernameAndPassword(String username, String password);
}
