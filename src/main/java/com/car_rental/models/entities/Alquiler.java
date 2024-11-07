package com.car_rental.models.entities;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(
        generator = ObjectIdGenerators.PropertyGenerator.class,
        property = "id"
)
public class Alquiler {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private LocalDate fecha_inicio;

    @Column(nullable = false)
    private LocalDate fecha_fin;

    @Column(nullable = false)
    private LocalDate fecha_entrega;

    @Column(nullable = false)
    private double costo;

    @ManyToOne
    @JoinColumn(name = "id_cliente")
    @JsonBackReference
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_empleado")
    @JsonBackReference
    private Empleado empleado;

    @OneToMany(
            cascade = CascadeType.ALL,
            mappedBy = "alquiler",
            fetch = FetchType.EAGER
    )
    @JsonManagedReference
    private List<Vehiculo> vehiculos;
}
