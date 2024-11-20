package com.example.demo.service;

import com.example.demo.Cars;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AdNewCar {
    @Autowired
    @Bean(name = "firstCar")
    public Cars createCar(){
        return new Cars(0, "марка", "тип двигателя");
    }


}
