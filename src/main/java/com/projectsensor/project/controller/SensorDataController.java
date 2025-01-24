package com.projectsensor.project.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projectsensor.project.entities.SensorData;
import com.projectsensor.project.service.SensorDataService;

@RestController
@RequestMapping("/sensor")
@CrossOrigin(origins = "http://localhost:3000")
public class SensorDataController {

    @Autowired
    private SensorDataService service;

    @GetMapping("/find/last")
    public  ResponseEntity<SensorData> obtenerUltimo() {
        return new ResponseEntity<>(service.obtenerUltimo(), HttpStatus.OK);
    }

    @GetMapping("/find/all")
    public ResponseEntity<List<SensorData>> obtenerTodo() {
        return new ResponseEntity<>(service.obtenerTodos(), HttpStatus.OK); 
    }

    @GetMapping("/find/{dispositivo}")
    public ResponseEntity<List<SensorData>> obtenerPorId(@PathVariable String dispositivo) {
        return new ResponseEntity<>(service.obtenerPorId(dispositivo), HttpStatus.OK); 
    }

    @PostMapping("/save")
    public ResponseEntity<SensorData> guardarRegistro(@RequestBody SensorData data){
        System.out.println(data);
        return new ResponseEntity<>(service.guardar(data), HttpStatus.OK);
    }

    @GetMapping("/find/week")
    public ResponseEntity<List<SensorData>> traerDataSemana(){
        return new ResponseEntity<>(service.traerDataSemana(), HttpStatus.OK);
    }

    @GetMapping("/find/day")
    public ResponseEntity<List<SensorData>> traerDiario(){
        return new ResponseEntity<>(service.traerDiario(), HttpStatus.OK);
    }


}
