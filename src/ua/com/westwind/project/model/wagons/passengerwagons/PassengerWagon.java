package ua.com.westwind.project.model.wagons.passengerwagons;

import ua.com.westwind.project.model.Wagons;

import java.util.ArrayList;

public abstract class PassengerWagon implements Wagons {

    protected TypeWagon typeWagon;
    protected int countPlace;
    protected ArrayList<Place>listPlace;


    protected abstract TypeWagon getPassengerTypeWagon();

    protected abstract  int getCountPlace();

    protected abstract  ArrayList<Place> getListPlace();

    @Override
    public String toString() {
        return "PassengerWagon{" +
                "typeWagon=" + typeWagon +
                ", countPlace=" + countPlace +
                ", listPlace=" + listPlace +
                '}';
    }
}
