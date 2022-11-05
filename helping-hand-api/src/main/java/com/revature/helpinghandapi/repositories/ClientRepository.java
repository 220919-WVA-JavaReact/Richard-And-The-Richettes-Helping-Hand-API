package com.revature.helpinghandapi.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.revature.helpinghandapi.entities.Client;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, String>{

}
