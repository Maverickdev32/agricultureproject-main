package com.projectsensor.project.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.projectsensor.project.entities.SensorData;

public interface SensorDataRepository extends JpaRepository<SensorData, Long> {

    SensorData findTopByOrderByTimestampDesc();

    List<SensorData> findByDispositivo(String dispositivo);

    @Query(value = "SELECT * FROM sensor WHERE timestamp >= NOW() - INTERVAL 7 DAY AND dispositivo != 'dispositivo_4'", nativeQuery = true)
    public List<SensorData> findBuscarPorSemana();

    @Query(value = "SELECT * FROM sensor WHERE DATE(timestamp) = CURDATE() AND dispositivo != 'dispositivo_4'", nativeQuery = true)
    public List<SensorData> findBuscarPorDia();

}
