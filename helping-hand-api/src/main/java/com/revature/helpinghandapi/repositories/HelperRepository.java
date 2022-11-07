package com.revature.helpinghandapi.repositories;

import com.revature.helpinghandapi.entities.Helper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HelperRepository  extends JpaRepository<Helper, String> {
}
