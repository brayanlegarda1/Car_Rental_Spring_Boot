package com.car_rental.dto;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

@Data
public class DataRegisterCarDto {

    private Integer id;

    private String name;

    private String color;

    private String transmission;

    private String brand;

    private String type;

    private Date modelYear;

    private String description;

    private Integer price;

    private MultipartFile image;

    private byte[] returnedImage;
}
