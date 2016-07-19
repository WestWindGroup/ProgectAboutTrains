package ua.com.westwind.project.model.wagons.passengerwagons;

import java.util.ArrayList;

public class PassengerWagonWithSeating extends PassengerWagon {

    private final TypePassengerWagon TYPE_WAGON = TypePassengerWagon.PASSENGER_WAGON_WITH_SEATING;
    private final int COUNT_PLACE = 60;

    public PassengerWagonWithSeating() {
        typePassengerWagon = TYPE_WAGON;
        countPlace = COUNT_PLACE;
        listPlace = new ArrayList<>(COUNT_PLACE);
    }

    public TypePassengerWagon getTypePassengerWagon() {
        return typePassengerWagon;
    }

    public int getCountPlace() {
        return countPlace;
    }

    public ArrayList<Place> getListPlace() {
        return listPlace;
    }
}
