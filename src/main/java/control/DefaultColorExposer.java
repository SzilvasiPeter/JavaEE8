package control;

import entity.Color;

import javax.enterprise.inject.Produces;

public class DefaultColorExposer {

    @Produces
    @Diesel
    public Color exposeDefaultColor(){
        // ...
        return Color.RED;
    }
}
