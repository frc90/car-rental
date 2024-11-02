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
public class Marca {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            nullable = false,
            length = 50
    )
    private String nombre;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "marca",
            orphanRemoval = true,
            fetch = FetchType.EAGER
    )
    private List<Vehiculo> vehiculo;
}
