package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.entity.Facilities;
import com.sun.xml.bind.v2.model.core.ID;

public interface FacilitiesRepository extends JpaRepository<Facilities, ID> {

}
