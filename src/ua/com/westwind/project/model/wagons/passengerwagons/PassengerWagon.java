package ua.com.westwind.project.model.wagons.passengerwagons;

import ua.com.westwind.project.model.Wagons;

import java.util.ArrayList;

public class PassengerWagon implements Wagons {

    protected TypeWagon typeWagon;
    protected int countPlace;
    protected ArrayList<Place>listPlace;

    public PassengerWagon(TypeWagon typeWagon, int countPlace) {
        this.typeWagon = typeWagon;
        this.countPlace = countPlace;
        this.listPlace = new ArrayList<>(countPlace);
    }

    public TypeWagon getTypeWagon() {
        return typeWagon;
    }

    public void setTypeWagon(TypeWagon typeWagon) {
        this.typeWagon = typeWagon;
    }

    public int getCountPlace() {
        return countPlace;
    }

    public void setCountPlace(int countPlace) {
        this.countPlace = countPlace;
    }

    public ArrayList<Place> getListPlace() {
        return listPlace;
    }

    public void setListPlace(ArrayList<Place> listPlace) {
        this.listPlace = listPlace;
    }
}
