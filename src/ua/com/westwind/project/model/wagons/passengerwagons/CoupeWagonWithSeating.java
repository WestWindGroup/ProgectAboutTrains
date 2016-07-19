package ua.com.westwind.project.model.wagons.passengerwagons;

import java.util.ArrayList;

public class CoupeWagonWithSeating extends PassengerWagon {

    private final TypePassengerWagon TYPE_WAGON = TypePassengerWagon.COUPE_WAGON_WITH_SEATING;
    private final int COUNT_PLACE = 42;

    public CoupeWagonWithSeating() {
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
