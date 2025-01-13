package com.liroa.garage.service.car;

import com.liroa.garage.domain.car.Car;
import com.liroa.garage.domain.car.DataCreateCar;
import com.liroa.garage.domain.car.DataListCar;
import com.liroa.garage.domain.car.DataUpdateCar;
import com.liroa.garage.domain.client.Client;
import com.liroa.garage.repository.CarRepository;
import com.liroa.garage.repository.ClientRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarServiceImpl implements CarService{

    @Autowired
    CarRepository carRepository;

    @Autowired
    ClientRepository clientRepository;


    @Override
    public void createCar(Long idClient, DataCreateCar dataCreateCar) {

        Client client = clientRepository.findById(idClient)
                .orElseThrow(()-> new RuntimeException("ID not found"));

        Car car = new Car();

        car.setBrand(dataCreateCar.brand());
        car.setModel(dataCreateCar.model());
        car.setComments(dataCreateCar.comments());
        car.setClient(client);

        carRepository.save(car);
    }

    @Override
    public List<DataListCar> getAllCars() {

        return carRepository.findAll().stream()

                .map(car -> new DataListCar(

                        car.getBrand(),
                        car.getModel(),
                        car.getComments()

                )).toList();

    }

    @Override
    public Car getCarById(Long idCar) {
        return carRepository.findById(idCar)
                .orElseThrow(()-> new EntityNotFoundException("id not found by id Car"));
    }

    @Override
    @Transactional
    public Car updateCar( Long idCar ,DataUpdateCar dataUpdateCar) {

        Car car = carRepository.findById(idCar).orElseThrow(()-> new RuntimeException("Id not found"));

        car.setBrand(dataUpdateCar.brand());
        car.setModel(dataUpdateCar.model());
        car.setComments(dataUpdateCar.comments());

        return carRepository.save(car);
    }

    @Override
    public void deleteCar(Long idCar) {

        Car car = carRepository.findById(idCar)
                .orElseThrow(()-> new RuntimeException("Id not found"));

        carRepository.delete(car);
    }
}
