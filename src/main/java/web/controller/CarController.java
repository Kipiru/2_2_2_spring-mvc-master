package web.controller;

import model.Car;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CarController {

    @GetMapping(value = "/cars")
    public String printCars(HttpServletRequest request, ModelMap model) {
        List<Car> carList = new ArrayList<>();
        List<Car> requestedCarList;
        String countParam = request.getParameter("count");
        carList.add(new Car("Porsche", "911", 1964));
        carList.add(new Car("Tesla", "S", 2021));
        carList.add(new Car("Nissan", "Leaf", 2010));
        carList.add(new Car("Ford", "Mustang", 1966));
        carList.add(new Car("Volkswagen", "Magic bus", 1969));



        if (countParam == null) {
            requestedCarList = carList;
        }
        else {
            requestedCarList = new ArrayList<>();
            int count = Integer.parseInt(countParam);
            if (count < carList.size()) {
                for (int i = 0; i < count; i++) {
                    requestedCarList.add(carList.get(i));
                }
            } else {
                requestedCarList = carList;
            }
        }

        model.addAttribute("requestedCarList", requestedCarList);

        return "cars";
    }
}
