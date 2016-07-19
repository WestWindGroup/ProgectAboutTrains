package ua.com.westwind.project.model.wagons.passengerwagons;

import java.util.ArrayList;

public class EconomPassengerWagon extends PassengerWagon {
    private final TypePassengerWagon TYPE_WAGON = TypePassengerWagon.ECONOM_PASSENGER_WAGON;
    private final int COUNT_PLACE = 54;

    public EconomPassengerWagon() {
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
