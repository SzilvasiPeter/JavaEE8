package boundary;

import control.CarFactory;
import control.CarRepository;
import control.CarStorageExecption;
import entity.Car;
import entity.EngineType;
import entity.Specification;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class CarManufacturer {

    @Inject
    CarFactory carFactory;

    //@Inject
    //CarRepository carRepository;

    @PersistenceContext
    EntityManager entityManager;
    //@Inject
    //Event<CarCreated> carCreated;

    //@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Car manufactureCar(Specification specification) throws CarStorageExecption {
        Car car = carFactory.createCar(specification);

        // Store car
        //carRepository.store(car);
        entityManager.persist(car);
        //throw new CarStorageExecption("!");
        //carCreated.fire(new CarCreated(car.getIdentifier()));
        return car;
    }

    public List<Car> retrieveCars(){

        //return carRepository.loadCars();
        return entityManager.createNamedQuery(Car.FIND_ALL, Car.class).getResultList();
    }

    public Car retrieveCar(String identifier) {
        Car car = new Car();
        car.setIdentifier(identifier);
        return car;
    }

    /*public List<Car> retrieveCars(EngineType filter) {
        return carRepository.loadCars().stream()
                .filter(c -> c.getEngineType() == filter)
                .collect(Collectors.toList());
    }*/
}
