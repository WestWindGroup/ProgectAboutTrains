package ua.com.westwind.project.model.wagons.passengerwagons;

import ua.com.westwind.project.model.Wagons;

import java.util.ArrayList;

public abstract class PassengerWagon implements Wagons {

    protected TypePassengerWagon typePassengerWagon;
    protected int countPlace;
    protected ArrayList<Place>listPlace;


    abstract  TypePassengerWagon getTypePassengerWagon();

    abstract  int getCountPlace();

    abstract  ArrayList<Place> getListPlace();
}
