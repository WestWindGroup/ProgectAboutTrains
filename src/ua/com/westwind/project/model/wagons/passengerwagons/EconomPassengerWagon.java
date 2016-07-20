package ua.com.westwind.project.model.wagons.passengerwagons;

import java.util.ArrayList;

public class EconomPassengerWagon extends PassengerWagon {
    private final PassengerTypeWagon TYPE_WAGON = PassengerTypeWagon.ECONOM_PASSENGER_WAGON;
    private final int COUNT_PLACE = 54;

    public EconomPassengerWagon() {
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
