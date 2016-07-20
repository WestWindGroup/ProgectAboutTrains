package ua.com.westwind.project.model.wagons.passengerwagons;

import java.util.ArrayList;

public class CoupeNormalWagon extends PassengerWagon {

    private final PassengerTypeWagon TYPE_WAGON = PassengerTypeWagon.COUPE;
    private final int COUNT_PLACE = 40;
    private final int COUNT_PLACE_UP = 20;
    private final int COUNT_PLACE_DOWN = 20;

    public CoupeNormalWagon() {
        typeWagon = TYPE_WAGON;
        countPlace = COUNT_PLACE;
        createListPlace();
    }

    private void createListPlace() {
        for (int i = 1; i <= COUNT_PLACE_UP;) {
            listPlace.add(new Place(i++ , TypePassengerPlace.UP_PLACE));
        }
        for (int i = COUNT_PLACE_UP + 1; i <= COUNT_PLACE_UP + COUNT_PLACE_DOWN; i++) {
            listPlace.add(new Place(i , TypePassengerPlace.DOWN_PLACE));
        }
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
