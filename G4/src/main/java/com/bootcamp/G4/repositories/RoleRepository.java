package com.bootcamp.G4.repositories;

import com.bootcamp.G4.model.Role;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	public Optional<Role> findByName(String name); 
}
