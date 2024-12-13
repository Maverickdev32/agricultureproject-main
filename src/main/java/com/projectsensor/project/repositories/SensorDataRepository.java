package com.projectsensor.project.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projectsensor.project.entities.SensorData;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    SensorData findTopByOrderByTimestampDesc();

}
