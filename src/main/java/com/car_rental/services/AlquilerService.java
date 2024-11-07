package com.car_rental.services;

import com.car_rental.models.entities.Alquiler;
import com.car_rental.repositories.AlquilerRepository;
import com.car_rental.services.impl.AlquilerServiceImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlquilerService implements AlquilerServiceImpl {

    private final AlquilerRepository alquilerRepository;

    public AlquilerService(AlquilerRepository alquilerRepository) {
        this.alquilerRepository = alquilerRepository;
    }

    @Override
    public List<Alquiler> getAllAlquilers() {
        return alquilerRepository.findAll();
    }

    @Override
    public Alquiler createAlquiler(Alquiler alquiler) {
        return alquilerRepository.save(alquiler);
    }

    @Override
    public Optional<Alquiler> getAlquiler(Long id) {
        Optional<Alquiler> alquiler = alquilerRepository.findById(id);
        if (alquiler.isPresent()) {
            return alquiler;
        }
        return null;
    }

    @Override
    public Alquiler updateAlquiler(Long id, Alquiler alquiler) {
        Optional<Alquiler> alquilerFinded = alquilerRepository.findById(id);
        if (alquilerFinded.isPresent()) {
            alquilerFinded.get().setCosto(alquiler.getCosto());
            alquilerFinded.get().setCliente(alquiler.getCliente());
            alquilerFinded.get().setVehiculos(alquiler.getVehiculos());
            alquilerFinded.get().setFecha_inicio(alquiler.getFecha_inicio());
            alquilerFinded.get().setFecha_fin(alquiler.getFecha_fin());
            alquilerFinded.get().setFecha_entrega(alquiler.getFecha_entrega());
            return alquiler;
        }
        return null;
    }

    @Override
    public String deleteAlquiler(Long id) {
        alquilerRepository.deleteById(id);
        Optional<Alquiler> alquiler = alquilerRepository.findById(id);
        if (!alquiler.isPresent()) {
            return "Was deleted!";
        }
        return "Not find";
    }
}
