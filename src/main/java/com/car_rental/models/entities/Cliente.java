package com.car_rental.models.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@NoArgsConstructor
public class Cliente extends User{
    @OneToMany(
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            orphanRemoval = true,
            mappedBy = "cliente"
    )
    private List<Alquiler> alquileres;


    public Cliente(Long id, String nombre, String email, String telefono, List<Alquiler> alquileres) {
        super(id, nombre, email, telefono);
        this.alquileres = alquileres;
    }
}
