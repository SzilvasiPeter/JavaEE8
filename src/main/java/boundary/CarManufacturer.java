package boundary;

import control.CarFactory;
import control.CarRepository;
import entity.Car;
import entity.CarCreated;
import entity.Specification;

import javax.ejb.Stateless;
import javax.enterprise.event.Event;
import javax.inject.Inject;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;

    @Inject
    CarRepository carRepository;

    @Inject
    Event<CarCreated> carCreated;

    public Car manufactureCar(Specification specification){
        Car car = carFactory.createCar(specification);

        // Store car
        carRepository.store(car);

        carCreated.fire(new CarCreated(car.getIdentifier()));
        return car;
    }
}
