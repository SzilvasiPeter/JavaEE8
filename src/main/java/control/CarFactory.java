package control;

import entity.Car;
import entity.Color;
import entity.Specification;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.UUID;

@Dependent
public class CarFactory {

    @Inject
    @Diesel
    Color defaultColor;

    @Inject
    @Config("identifier.prefix")
    String identifierPrefix;

    @Transactional(rollbackOn = CarStorageExecption.class)
    public Car createCar(Specification specification) {
        //if( new Random().nextBoolean())
        //    throw new CarCreationException("could not create car");
        Car car = new Car();
        car.setIdentifier(identifierPrefix + "-" + UUID.randomUUID().toString());
        car.setColor(specification.getColor()==null? defaultColor: specification.getColor());
        car.setEngineType(specification.getEngineType());
        return car;
    }
}