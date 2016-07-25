package ua.com.westwind.project.model.wagons.passengerwagons;

import ua.com.westwind.project.model.wagons.Wagons;
import ua.com.westwind.project.model.wagons.place.Place;

import java.util.ArrayList;

public abstract class PassengerWagon implements Wagons,Comparable<PassengerWagon> {

    protected int countPlace;
    protected int countBusyPlace;
    protected double allMassBaggege;
    protected TypeWagon typeWagon;
    protected ArrayList<Place>listPlace;

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

        return this.typeWagon.getComfortLevel() - ob.typeWagon.getComfortLevel();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PassengerWagon that = (PassengerWagon) o;

        if (countPlace != that.countPlace) return false;
        if (typeWagon != null ? !typeWagon.equals(that.typeWagon) : that.typeWagon != null) return false;
        return listPlace != null ? listPlace.equals(that.listPlace) : that.listPlace == null;

    }

    @Override
    public int hashCode() {
        int result = countPlace;
        result = 31 * result + (typeWagon != null ? typeWagon.hashCode() : 0);
        result = 31 * result + (listPlace != null ? listPlace.hashCode() : 0);
        return result;
    }
}
