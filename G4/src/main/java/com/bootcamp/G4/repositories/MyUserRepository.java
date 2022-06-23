package com.bootcamp.G4.repositories;

import com.bootcamp.G4.model.MyUser;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MyUserRepository extends JpaRepository<MyUser, Long>{

	public Optional<MyUser> findByUsername(String username);
	public Optional<MyUser> findByRole(String role);

	@Query(value = "SELECT name FROM my_user INNER JOIN role ON my_user.role_id=role.id WHERE username=:username", nativeQuery = true)
    public String getRole(@Param("username") String username);
}
