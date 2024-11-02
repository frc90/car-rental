package com.car_rental.repositories;

import com.car_rental.models.entities.Alquiler;
import com.car_rental.models.entities.Cliente;
import com.car_rental.models.entities.Empleado;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AlquilerRepositoryTest {
    @Autowired
    private AlquilerRepository alquilerRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EmpleadoRepository empleadoRepository;

    @BeforeEach
    void setUp() {
        alquilerRepository.deleteAll();
        clienteRepository.deleteAll();
        empleadoRepository.deleteAll();
    }

    @Test
    public void createALquiler(){
        Cliente cliente1 = clienteRepository.findById(1L).orElseGet(() -> clienteRepository.save(new Cliente(1L, "pancho", "panch@ema.com", "1225166", null)));
        Empleado empleado1 = empleadoRepository.findById(1L).orElseGet(() -> empleadoRepository.save(new Empleado(1L, "fran", "fran@gma.com", "745615155", "fran", "1233", null)));
        Alquiler alquiler1 = new Alquiler(
                1L,
                LocalDate.of(2024, 11, 2),
                LocalDate.of(2025, 1, 30),
                LocalDate.of(2025, 2, 1),
                45.51,
                cliente1,
                empleado1,
                null
        );
        alquilerRepository.save(alquiler1);
    }
}