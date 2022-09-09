package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.User;
import com.sun.xml.bind.v2.model.core.ID;

public interface UserRepository extends JpaRepository<User, ID> {

}
