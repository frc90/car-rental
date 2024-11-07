package com.car_rental.services.impl;

import com.car_rental.models.entities.Alquiler;

import java.util.List;
import java.util.Optional;

public interface AlquilerServiceImpl{
    List<Alquiler> getAllAlquilers();
    Alquiler createAlquiler(Alquiler alquiler);
    Optional<Alquiler> getAlquiler(Long id);
    Alquiler updateAlquiler(Long id, Alquiler alquiler);
    String deleteAlquiler(Long id);
}
