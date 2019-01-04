package boundary;

import entity.Car;
import entity.EngineType;
import entity.Specification;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.stream.JsonCollectors;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.net.URI;
import java.util.List;

@Path("cars")
public class CarsResource {

    @Inject
    CarManufacturer carManufacturer;

    @Context
    UriInfo uriInfo;

    @GET
    public JsonArray retrieveCars(@NotNull @QueryParam("filter")EngineType engineType){
        List<Car> cars = carManufacturer.retrieveCars(engineType);
        return cars
                .stream()
                .map(c -> Json.createObjectBuilder()
                    .add("color", c.getColor().name())
                    .add("engine", c.getEngineType().name())
                    .add("id", c.getIdentifier())
                    .add("hello", "value")
                    .build())
                .collect(JsonCollectors.toJsonArray());
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createCar(@Valid @NotNull Specification specification){
        Car car = carManufacturer.manufactureCar(specification);
        URI uri = uriInfo.getBaseUriBuilder()
                .path(CarsResource.class)
                .path(CarsResource.class, "retrieveCar")
                .build(car.getIdentifier());
        return Response.created(uri).build();
    }

    @GET
    @Path("{id}")
    public Car retrieveCar(@PathParam("id") String identifier){
        return carManufacturer.retrieveCar(identifier);
    }
}
