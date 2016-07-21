package ua.com.westwind.project.model.wagons.passengerwagons;

import ua.com.westwind.project.model.Wagons;

import java.util.ArrayList;

public abstract class PassengerWagon implements Wagons {

    protected TypeWagon typeWagon;
    protected int countPlace;
    protected ArrayList<Place>listPlace;
    protected int countBusyPlace;

    public abstract int getCountBusyPlace();

    public abstract void setCountBusyPlace(int countBusyPlace);

    public abstract TypeWagon getPassengerTypeWagon();

    public abstract  int getCountPlace();

    public abstract  ArrayList<Place> getListPlace();

    @Override
    public String toString() {
        return "PassengerWagon : " +
                "typeWagon = " + typeWagon +
                ", countPlace = " + countPlace +
                ", countBusyPlace = " + countBusyPlace ;
//                "," + "\n" + listPlace;
    }
}
