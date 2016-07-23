package ua.com.westwind.project.model.wagons.passengerwagons;

import ua.com.westwind.project.model.wagons.Wagons;
import ua.com.westwind.project.model.wagons.place.Place;

import java.util.ArrayList;

public abstract class PassengerWagon implements Wagons,Comparable<PassengerWagon> {

    protected TypeWagon typeWagon;
    protected int countPlace;
    protected ArrayList<Place>listPlace;
    protected int countBusyPlace;
    protected double allMassBaggege;

    public double getAllMassBaggege() {
        return allMassBaggege;
    }

    public void setAllMassBaggege(double allMassBaggege) {
        this.allMassBaggege = allMassBaggege;
    }

    public abstract int getCountBusyPlace();

    public abstract void setCountBusyPlace(int countBusyPlace);

    public abstract TypeWagon getPassengerTypeWagon();

    public abstract  int getCountPlace();

    public abstract  ArrayList<Place> getListPlace();

    @Override
    public String toString() {
        return "\n PassengerWagon | " +
                "typeWagon = " + typeWagon +
                " | countPlace = " + countPlace +
                " | countBusyPlace = " + countBusyPlace;
    }


    @Override
    public int compareTo(PassengerWagon ob) {
        if(ob == null)
            return -1;
        if(ob.getPassengerTypeWagon() == null)
            return -1;

        return ob.typeWagon.getComfortLevel() - this.typeWagon.getComfortLevel();
    }
}
