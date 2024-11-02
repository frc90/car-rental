package com.car_rental.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Empleado extends User{
    @Column(
            nullable = false,
            length = 20
    )
    private String usuario;

    @Column(
            nullable = false,
            length = 20
    )
    private String clave;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "empleado",
            fetch = FetchType.EAGER,
            orphanRemoval = true
    )
    private List<Alquiler> alquileres;

    public Empleado(Long id, String nombre, String email, String telefono, String usuario, String clave, List<Alquiler> alquileres) {
        super(id, nombre, email, telefono);
        this.usuario = usuario;
        this.clave = clave;
        this.alquileres = alquileres;
    }
}
