package ua.com.westwind.project.model.wagons.passengerwagons;

import ua.com.westwind.project.model.Wagons;

import java.util.ArrayList;

public class PassengerWagon implements Wagons {

    protected TypePassengerWagon typePassengerWagon;
    protected int countPlace;
    protected ArrayList<Place>listPlace;

    public PassengerWagon(TypePassengerWagon typePassengerWagon, int countPlace) {
        this.typePassengerWagon = typePassengerWagon;
        this.countPlace = countPlace;
        this.listPlace = new ArrayList<>(countPlace);
    }

    public TypePassengerWagon getTypePassengerWagon() {
        return typePassengerWagon;
    }

    public void setTypePassengerWagon(TypePassengerWagon typePassengerWagon) {
        this.typePassengerWagon = typePassengerWagon;
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
