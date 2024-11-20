package com.example.demo.controller;
import com.example.demo.service.AdNewCar;
import com.example.demo.Cars;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Controller
public class Controller1 {

    List<Cars> allCars = new ArrayList<>();

    @GetMapping("/")
    public String home(Model model){

        return "index";
    }
   @GetMapping("/add")
    public String createCar( int id, String brand, String typeEngine, Model m ) {
        String message = null;
        ApplicationContext context = new AnnotationConfigApplicationContext(AdNewCar.class);
        if(isFirst()) {
            Cars carFirst = context.getBean("firstCar", Cars.class);
            allCars.add(carFirst);
        }
        try {
            allCars.add(new Cars(id, brand, typeEngine));
            message = "Добавлено";
            m.addAllAttributes(Map.of("brand", brand, "id", id, "typeEngine", typeEngine, "message", message));

        }catch (Exception e){
            message = e.getMessage();
            m.addAttribute("message", message);
        }
            return "add";
    }
    @GetMapping("/cars")
    public String cars(Model model){
        model.addAttribute("allCars", allCars);
        return "cars";
    }
    public boolean isFirst(){
        for (Cars c: allCars) {
            if (c.equals(new Cars(0, "марка", "тип двигателя")))
                return false;
        }
        return true;
    }

}
