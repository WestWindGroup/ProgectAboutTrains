package ua.com.westwind.project.model.wagons.passengerwagons;

import java.util.ArrayList;

public class EconomPassengerWagon extends PassengerWagon {
    private final PassengerTypeWagon TYPE_WAGON = PassengerTypeWagon.ECONOM_PASSENGER_WAGON;
    private final int COUNT_PLACE = 54;
    private final int COUNT_PLACE_UP = 18;
    private final int COUNT_PLACE_DOWN = 18;
    private final int COUNT_PLACE_SIDE_UP = 9;
    private final int COUNT_PLACE_SIDE_DOWN = 9;

    public EconomPassengerWagon() {
        typeWagon = TYPE_WAGON;
        countPlace = COUNT_PLACE;
        createListPlace();
    }

    private void createListPlace() {
        int i;
        for (i = 1; i <= COUNT_PLACE_DOWN;) {
            listPlace.add(new Place(i++ , TypePassengerPlace.DOWN_PLACE));
        }
        int k = i;
        for (; k < i + COUNT_PLACE_UP;) {
            listPlace.add(new Place(k++ , TypePassengerPlace.UP_PLACE));
        }
        int j = k;
        for (; j < k + COUNT_PLACE_SIDE_DOWN;) {
            listPlace.add(new Place(j++ , TypePassengerPlace.SIDE_PLACE_DOWN));
        }
        int d = j;
        for (; d < j + COUNT_PLACE_SIDE_UP;) {
            listPlace.add(new Place(d++ , TypePassengerPlace.SIDE_PLACE_UP));
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
