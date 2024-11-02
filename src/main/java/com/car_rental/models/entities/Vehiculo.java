package com.car_rental.models.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(
            unique = true,
            nullable = false,
            length = 10
    )
    private String placa;

    @ManyToOne
    @JoinColumn(name = "id_marca")
    private Marca marca;

    @ManyToOne
    @JoinColumn(name = "id_estado")
    private Estado estado;

    @ManyToOne
    @JoinColumn(name = "id_tipo")
    private Tipo tipo;

    @ManyToOne
    @JoinColumn(name = "id_alquiler")
    private Alquiler alquiler;
}
