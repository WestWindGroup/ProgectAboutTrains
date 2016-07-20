package ua.com.westwind.project.model.wagons.passengerwagons;

import java.util.ArrayList;

public class PassengerWagonWithSeating extends PassengerWagon {

    private final PassengerTypeWagon TYPE_WAGON = PassengerTypeWagon.PASSENGER_WAGON_WITH_SEATING;
    private final int COUNT_PLACE = 60;

    public PassengerWagonWithSeating() {
        typeWagon = TYPE_WAGON;
        countPlace = COUNT_PLACE;
        listPlace = new ArrayList<>(COUNT_PLACE);
    }

    public TypeWagon getPassengerTypeWagon() {
        return typeWagon;
    }

    public int getCountPlace() {
        return countPlace;
    }

    public ArrayList<Place> getListPlace() {
        return listPlace;
    }
}
