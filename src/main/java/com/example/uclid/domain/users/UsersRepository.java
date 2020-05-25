package com.example.uclid.domain.users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Long> {

    @Query("SELECT p FROM Users p ORDER BY p.colNum DESC")
    List<Users> findAllDesc();

}
