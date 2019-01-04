package boundary;

import control.CarFactory;
import control.CarRepository;
import entity.Car;
import entity.EngineType;
import entity.Specification;

import javax.ejb.Stateless;
import javax.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;

    @Inject
    CarRepository carRepository;

    //@Inject
    //Event<CarCreated> carCreated;

    public Car manufactureCar(Specification specification){
        Car car = carFactory.createCar(specification);

        // Store car
        carRepository.store(car);

        //carCreated.fire(new CarCreated(car.getIdentifier()));
        return car;
    }

    public List<Car> retrieveCars(){
        return carRepository.loadCars();
    }

    public Car retrieveCar(String identifier) {
        Car car = new Car();
        car.setIdentifier(identifier);
        return car;
    }

    public List<Car> retrieveCars(EngineType filter) {
        return carRepository.loadCars().stream()
                .filter(c -> c.getEngineType() == filter)
                .collect(Collectors.toList());
    }
}
