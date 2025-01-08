package com.liroa.garage.controller;


import com.liroa.garage.domain.car.Car;
import com.liroa.garage.domain.car.DataCreateCar;
import com.liroa.garage.domain.car.DataListCar;
import com.liroa.garage.domain.car.DataUpdateCar;
import com.liroa.garage.service.car.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping("/{idClient}")
    public ResponseEntity<Car> createCar(@PathVariable Long idClient, @RequestBody DataCreateCar dataCreateCar){

        carService.createCar(idClient, dataCreateCar);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<DataListCar>> getAllCars(){

        return ResponseEntity.ok(carService.getAllCars());
    }

    @GetMapping("/{idCar}")
    public ResponseEntity<Car> getCarById(@PathVariable Long idCar){

        return ResponseEntity.ok(carService.getCarById(idCar));

    }

    @PutMapping("/{idCar}")
    public ResponseEntity<?> updateCar(@PathVariable Long idCar , @RequestBody DataUpdateCar dataUpdateCar){

        Car car = carService.updateCar(idCar, dataUpdateCar);

        return ResponseEntity.ok(new DataUpdateCar(car.getBrand(), car.getModel(), car.getComments()));
    }

    @DeleteMapping("/{idCar}")
    public ResponseEntity<?> deleteCar(@PathVariable Long idCar){

        carService.deleteCar(idCar);

        return ResponseEntity.noContent().build();

    }




}
