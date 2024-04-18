package com.car_rental.Services.admin;

import com.car_rental.dto.DataRegisterCarDto;

import java.util.List;

public interface AdminService {

    boolean postCar(DataRegisterCarDto dataRegisterCarDto);
    List<DataRegisterCarDto> getAllCars();

    void deleteCar(Long carId);

    DataRegisterCarDto getCarById(Long carId);
}
