package com.bootcamp.G4.repositories;

import com.bootcamp.G4.model.MyUser;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<MyUser,String> {


    @Query(value = "SELECT name FROM my_users INNER JOIN roles ON my_user.role_id=role.id WHERE username=:username", nativeQuery = true)
    public String getRole(@Param("username") String username);

    public MyUser findByUsername(String username);
}