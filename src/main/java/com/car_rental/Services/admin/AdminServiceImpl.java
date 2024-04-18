package com.car_rental.Services.admin;

import com.car_rental.dto.DataRegisterCarDto;
import com.car_rental.model.Car;
import com.car_rental.repository.CarRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdminServiceImpl implements AdminService{


    private final CarRepository carRepository;


    @Override
    public boolean postCar(DataRegisterCarDto dataRegisterCarDto) {

        try{

            Car car = new Car();

            car.setName(dataRegisterCarDto.getName());
            car.setBrand(dataRegisterCarDto.getBrand());
            car.setColor(dataRegisterCarDto.getColor());
            car.setPrice(dataRegisterCarDto.getPrice());
            car.setType(dataRegisterCarDto.getType());
            car.setDescription(dataRegisterCarDto.getDescription());
            car.setModelYear(dataRegisterCarDto.getModelYear());
            car.setTransmission(dataRegisterCarDto.getTransmission());
            car.setImage(dataRegisterCarDto.getImage().getBytes());

            carRepository.save(car);
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    @Override
    public List<DataRegisterCarDto> getAllCars() {
        return carRepository.findAll().stream().map(Car::getCarDto).collect(Collectors.toList());
    }

    @Override
    public void deleteCar(Long carId) {
        carRepository.deleteById(carId);
    }

    @Override
    public DataRegisterCarDto getCarById(Long carId) {

        Optional<Car> optionalCar = carRepository.findById(carId);
        return optionalCar.map(Car::getCarDto).orElse(null);
    }
}
