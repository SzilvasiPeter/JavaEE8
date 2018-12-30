package control;

import entity.Specification;
import entity.Car;
import entity.Color;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import java.util.UUID;

@Dependent
public class CarFactory {

    @Inject
    @Diesel
    Color defaultColor;

    public Car createCar(Specification specification) {
        Car car = new Car();
        car.setIdentifier(UUID.randomUUID().toString());
        car.setColor(specification.getColor()==null? defaultColor: specification.getColor());
        car.setEngineType(specification.getEngineType());
        return car;
    }
}