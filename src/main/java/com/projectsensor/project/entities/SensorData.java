package com.projectsensor.project.entities;


import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "sensor")
public class SensorData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private float temperatura_ambiente;
    private float humedad;
    private float tempSensor1;
    private float tempSensor2;
    private float co2;
    private float tds;

    private LocalDateTime timestamp = LocalDateTime.now();

    // @ManyToOne()
    // @JoinColumn(name="usuario_id")
    // private Usuario usuario;

}
