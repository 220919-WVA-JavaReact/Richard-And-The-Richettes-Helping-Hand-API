package com.revature.helpinghandapi.repositories;
import com.revature.helpinghandapi.entities.Helper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface HelperRepository extends JpaRepository<Helper, Integer> {
    Optional<Helper> getHelperByUsername(String username);

    Optional<Helper> getHelperByUsernameAndPassword(String username, String password);
    
}
