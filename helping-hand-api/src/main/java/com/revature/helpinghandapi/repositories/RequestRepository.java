package com.revature.helpinghandapi.repositories;

import com.revature.helpinghandapi.entities.Client;
import com.revature.helpinghandapi.entities.Helper;
import com.revature.helpinghandapi.entities.Request;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;


@Repository
public interface RequestRepository extends JpaRepository<Request, String> {

//      Optional<Request> findRequestById(String id);
//      Optional<Request> findRequestByHelper(Helper username, Request id);
//      List<Request> findRequestByClientId(Client id);
}
