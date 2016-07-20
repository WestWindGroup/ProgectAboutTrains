package ua.com.westwind.project.model.wagons.passengerwagons;

import ua.com.westwind.project.model.Wagons;

import java.util.ArrayList;

public abstract class PassengerWagon implements Wagons {

    protected TypeWagon typeWagon;
    protected int countPlace;
    protected ArrayList<Place>listPlace;


    abstract TypeWagon getPassengerTypeWagon();

    abstract  int getCountPlace();

    abstract  ArrayList<Place> getListPlace();
}
