package com.car_rental.repositories;

import com.car_rental.models.entities.Estado;
import com.car_rental.models.entities.Marca;
import com.car_rental.models.entities.Tipo;
import com.car_rental.models.entities.Vehiculo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;


@SpringBootTest
class VehiculoRepositoryTest {
    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @BeforeEach
    void setUp() {
        vehiculoRepository.deleteAll();
        estadoRepository.deleteAll();
        tipoRepository.deleteAll();
        marcaRepository.deleteAll();
    }

    @Test
    public void createVehiculo(){
        // Marca
        Marca marca1 = marcaRepository.findById(1L)
                .orElseGet(() -> marcaRepository.save(new Marca(1L, "Mercedes", null)));
        Marca marca2 = marcaRepository.findById(2L)
                .orElseGet(() -> marcaRepository.save(new Marca(2L, "Mazda", null)));
        Marca marca3 = marcaRepository.findById(3L)
                .orElseGet(() -> marcaRepository.save(new Marca(3L, "Peugeot", null)));

        // Tipo
        Tipo tipo1 = tipoRepository.findById(1L)
                .orElseGet(() -> tipoRepository.save(new Tipo(1L, "MD-3", "Marca Mercedes, modelo MS-3", 10.50, null)));
        Tipo tipo2 = tipoRepository.findById(2L)
                .orElseGet(() -> tipoRepository.save(new Tipo(2L, "MZ", "Marca Mazda, modelo MZ", 10.50, null)));
        Tipo tipo3 = tipoRepository.findById(3L)
                .orElseGet(() -> tipoRepository.save(new Tipo(3L, "P-5", "Marca Peugeot, modelo MP-5", 10.50, null)));

        // Estado
        Estado estado1 = estadoRepository.findById(1L)
                .orElseGet(() -> estadoRepository.save(new Estado(1L, "Buen Estado", null)));
        Estado estado2 = estadoRepository.findById(2L)
                .orElseGet(() -> estadoRepository.save(new Estado(2L, "Excelente Estado", null)));
        Estado estado3 = estadoRepository.findById(3L)
                .orElseGet(() -> estadoRepository.save(new Estado(3L, "Mal Estado", null)));

        // Vehículo
        Vehiculo vehiculo = new Vehiculo(null, "uru-456", marca1, estado1, tipo1);
        vehiculoRepository.save(vehiculo);
    }
}