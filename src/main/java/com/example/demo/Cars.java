package com.example.demo;


import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class Cars {
   
    int id;
    String brand;
    String typeEngine;
    public Cars(){}

    public Cars(int id, String brand, String typeEngine) {
        this.id = id;
        this.brand = brand;
        this.typeEngine = typeEngine;

    }





    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getTypeEngine() {
        return typeEngine;
    }

    public void setTypeEngine(String typeEngine) {
        this.typeEngine = typeEngine;
    }



    @Override
    public String toString() {
        return "Cars{" +
                "brand='" + brand + '\'' +
                ", typeEngine='" + typeEngine + '\'' +
                ", id='" + id + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cars cars = (Cars) o;
        return Objects.equals(id, cars.id) && Objects.equals(brand, cars.brand) && Objects.equals(typeEngine, cars.typeEngine);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, typeEngine);
    }
}
