package ua.com.westwind.project.model.wagons.passengerwagons;

import ua.com.westwind.project.model.wagons.place.Place;
import ua.com.westwind.project.model.wagons.place.TypePassengerPlace;

import java.util.ArrayList;

public class CoupeWagonWithSeating extends PassengerWagon {

    private final PassengerTypeWagon TYPE_WAGON = PassengerTypeWagon.COUPE_WAGON_WITH_SEATING;
    private final int COUNT_PLACE = 42;

    public CoupeWagonWithSeating() {
        typeWagon = TYPE_WAGON;
        countPlace = COUNT_PLACE;
        listPlace = new ArrayList<>();
        createListPlace();
    }
    private void createListPlace() {
        for (int i = 1; i <= COUNT_PLACE;) {
            listPlace.add(new Place(i++ , TypePassengerPlace.SEAT_PLACE));
        }

    }

}
