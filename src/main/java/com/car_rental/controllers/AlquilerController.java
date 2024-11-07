package com.car_rental.controllers;

import com.car_rental.models.entities.Alquiler;
import com.car_rental.repositories.AlquilerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AlquilerController {

    private final AlquilerRepository alquilerRepository;

    AlquilerController(AlquilerRepository alquilerRepository){
        this.alquilerRepository = alquilerRepository;
    }

    @GetMapping(value = "/alquilers")
    public List<Alquiler> getAllAlquilers(){
        return alquilerRepository.findAll();
    }
}
