package service;

import model.Car;


import java.util.ArrayList;
import java.util.List;

public class CarServiceImpl implements CarService {
    List<Car> carList;

    public CarServiceImpl() {
        carList = new ArrayList<>();
        carList.add(new Car("Porsche", "911", 1964));
        carList.add(new Car("Tesla", "S", 2021));
        carList.add(new Car("Nissan", "Leaf", 2010));
        carList.add(new Car("Ford", "Mustang", 1966));
        carList.add(new Car("Volkswagen", "Magic bus", 1969));
    }

    @Override
    public List<Car> getCars() {
        return carList;
    }

    @Override
    public List<Car> getCars(Integer count) {
        List<Car> requestedCarList = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            requestedCarList.add(carList.get(i));
        }
        return requestedCarList;
    }
}