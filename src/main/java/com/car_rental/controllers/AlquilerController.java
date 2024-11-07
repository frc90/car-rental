package com.car_rental.controllers;

import com.car_rental.models.entities.Alquiler;
import com.car_rental.services.AlquilerService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class AlquilerController {

    private final AlquilerService alquilerService;

    AlquilerController(AlquilerService alquilerService){
        this.alquilerService = alquilerService;
    }

    @GetMapping(value = "/alquilers")
    public List<Alquiler> getAllAlquilers(){
        return alquilerService.getAllAlquilers();
    }

    @GetMapping(value = "/alquiler/{id}")
    public Optional<Alquiler> getAlquiler(@PathVariable Long id){
        return alquilerService.getAlquiler(id);
    }

    @PostMapping(value = "/alquiler")
    public Alquiler createAlquiler(@RequestBody Alquiler alquiler){
        return alquilerService.createAlquiler(alquiler);
    }

    @PutMapping(value = "/alquiler/{id}")
    public Alquiler updateAlquiler(@PathVariable Long id, @RequestBody Alquiler alquiler){
        return alquilerService.updateAlquiler(id, alquiler);
    }

    @DeleteMapping(value = "/alquiler/{id}")
    public String deleteAlquiler(@PathVariable Long id){
        return alquilerService.deleteAlquiler(id);
    }
}
