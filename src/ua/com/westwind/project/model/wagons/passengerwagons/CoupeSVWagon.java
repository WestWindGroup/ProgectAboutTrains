package ua.com.westwind.project.model.wagons.passengerwagons;

import java.util.ArrayList;

public class CoupeSVWagon extends PassengerWagon {

    private final TypePassengerWagon TYPE_WAGON = TypePassengerWagon.COUPE_SV;
    private final int COUNT_PLACE = 20;

    public CoupeSVWagon() {
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
