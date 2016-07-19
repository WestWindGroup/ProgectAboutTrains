package ua.com.westwind.project.model.wagons.passengerwagons;

import java.util.ArrayList;

public class CoupeNormalWagon extends PassengerWagon {

    private final TypePassengerWagon TYPE_WAGON = TypePassengerWagon.COUPE;
    private final int COUNT_PLACE = 40;

    public CoupeNormalWagon() {
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
