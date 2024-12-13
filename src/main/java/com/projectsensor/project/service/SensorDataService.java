package com.projectsensor.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.projectsensor.project.entities.SensorData;
import com.projectsensor.project.repositories.SensorDataRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class SensorDataService {
    
    private final SensorDataRepository repository;

    public SensorData guardar(SensorData data) {
        return repository.save(data);
    }

    public List<SensorData> obtenerTodos() {
        return repository.findAll();
    }

    public SensorData obtenerUltimo() {
        return repository.findTopByOrderByTimestampDesc();
    }
    
}
