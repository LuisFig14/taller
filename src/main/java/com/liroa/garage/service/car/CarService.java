package com.liroa.garage.service.car;

import com.liroa.garage.domain.car.Car;
import com.liroa.garage.domain.car.DataCreateCar;
import com.liroa.garage.domain.car.DataListCar;
import com.liroa.garage.domain.car.DataUpdateCar;

import java.util.List;

public interface CarService {

    void createCar(Long idClient, DataCreateCar dataCreateCar);

    List<DataListCar> getAllCars();

    Car getCarById(Long idCar);

    Car updateCar (Long idCar, DataUpdateCar dataUpdateCar);

    void deleteCar (Long idCar);

}
