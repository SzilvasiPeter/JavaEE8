package control;

import entity.Car;
import entity.Color;
import entity.EngineType;

import java.util.ArrayList;
import java.util.List;

public class CarRepository {

    List<Car> cars = new ArrayList<>();

    public void store(Car car) {
        // ...
    }

    public List<Car> loadCars() {

        Car car1 = new Car();
        car1.setColor(Color.BLACK);
        car1.setEngineType(EngineType.PETROL);
        car1.setIdentifier("Ford");

        Car car2 = new Car();
        car2.setColor(Color.BLACK);
        car2.setEngineType(EngineType.PETROL);
        car2.setIdentifier("Ford");

        cars.add(car1);
        cars.add(car2);
        return cars;
    }

    public Car getCar(String identifier) {
        for(Car car : cars) {
            if(car.getIdentifier().equals(identifier)){
                return car;
            }
        }
        return null;
    }

    public List<Car> getCarByEngineType(EngineType engineType) {
        List<Car> carsByEngineType = new ArrayList<>();
        for(Car car : cars){
            if(car.getEngineType() == engineType){
                carsByEngineType.add(car);
            }
        }
        return carsByEngineType;
    }
}
