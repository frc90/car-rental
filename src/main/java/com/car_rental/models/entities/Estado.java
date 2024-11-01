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
public class Estado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_estado;

    @Column(
            nullable = false,
            length = 20
    )
    private String descripcion;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "estado",
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Vehiculo> vehiculo;
}
