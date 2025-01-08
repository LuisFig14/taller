package com.liroa.garage.repository;

import com.liroa.garage.domain.car.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car, Long> {
}
