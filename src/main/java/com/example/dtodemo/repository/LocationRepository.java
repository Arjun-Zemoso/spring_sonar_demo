package com.example.dtodemo.repository;

import com.example.dtodemo.model.Location;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationRepository extends JpaRepository<Location,Long> {}
