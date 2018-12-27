package control;

import boundary.CarRepository;
import entity.Car;
import entity.Specification;

import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;

    @Inject
    CarRepository carRepository;

    public Car manufactureCar(Specification specification){
        Car car = carFactory.createCar(specification);

        // Store car
        carRepository.store(car);
        return car;
    }

    private Car createCar(Specification specification) {
        return carFactory.createCar(specification);
    }
}
