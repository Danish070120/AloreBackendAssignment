package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Hotel;
import com.sun.xml.bind.v2.model.core.ID;

public interface HotelRepository extends JpaRepository<Hotel, ID> {

}
