package com.car_rental.repositories;

import com.car_rental.models.entities.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MarcaRepository extends JpaRepository<Marca, Long> {

}
