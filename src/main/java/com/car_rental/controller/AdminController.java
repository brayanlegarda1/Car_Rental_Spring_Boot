package com.car_rental.controller;

import com.car_rental.Services.admin.AdminServiceImpl;
import com.car_rental.dto.DataRegisterCarDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminServiceImpl adminService;

    @PostMapping("/car")
    public ResponseEntity<?> postCar(@ModelAttribute DataRegisterCarDto dataRegisterCarDto){

        boolean success = adminService.postCar(dataRegisterCarDto);

        if(success){
            return ResponseEntity.status(HttpStatus.CREATED).build();
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();

    }

    @GetMapping("/cars")
    public ResponseEntity<?> getAllCars(){
        List<DataRegisterCarDto> carDtos = adminService.getAllCars();
        return  ResponseEntity.ok(carDtos);

    }

    @DeleteMapping("/car/{carId}")
    public ResponseEntity<Void> deleteCar(@PathVariable Long carId){
        adminService.deleteCar(carId);
        return  ResponseEntity.noContent().build();
    }

    @GetMapping("/car/{carId}")
    public ResponseEntity<DataRegisterCarDto> getCarById(@PathVariable Long carId){

        DataRegisterCarDto carDto = adminService.getCarById(carId);

        if(carDto != null) return ResponseEntity.ok(carDto);

        return ResponseEntity.notFound().build();
    }

}
