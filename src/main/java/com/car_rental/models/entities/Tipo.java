package com.car_rental.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Tipo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            length = 100
    )
    private String descripcion;

    @Column(
            length = 1000
    )
    private String descripcion_ampliada;

    @Column(
            nullable = false,
            length = 100
    )
    private double costo_alquiler;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "tipo",
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Vehiculo> vehiculo;
}
