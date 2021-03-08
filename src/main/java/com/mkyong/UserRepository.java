package com.mkyong;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<Users, Long> {

    @Query("SELECT u FROM Users u WHERE u.status = ?1 and u.name = ?2")
    Users findUserByStatusAndName(String status, String name);

}
