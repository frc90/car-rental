package com.car_rental.repositories;

import com.car_rental.models.entities.Tipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TipoRepository extends JpaRepository<Tipo, Long> {
}
