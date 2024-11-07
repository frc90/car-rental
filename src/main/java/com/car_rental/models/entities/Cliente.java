package com.car_rental.models.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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
    @JsonManagedReference
    private List<Alquiler> alquileres;


    public Cliente(Long id, String nombre, String email, String telefono, List<Alquiler> alquileres) {
        super(id, nombre, email, telefono);
        this.alquileres = alquileres;
    }
}
