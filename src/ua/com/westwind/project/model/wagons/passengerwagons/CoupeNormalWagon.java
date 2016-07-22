package ua.com.westwind.project.model.wagons.passengerwagons;

import ua.com.westwind.project.model.wagons.place.Place;
import ua.com.westwind.project.model.wagons.place.TypePassengerPlace;

import java.util.ArrayList;

public class CoupeNormalWagon extends PassengerWagon {

    private final PassengerTypeWagon TYPE_WAGON = PassengerTypeWagon.COUPE;
    private final int COUNT_PLACE = 40;
    private final int COUNT_PLACE_UP = 20;
    private final int COUNT_PLACE_DOWN = 20;

    public CoupeNormalWagon() {
        typeWagon = TYPE_WAGON;
        countPlace = COUNT_PLACE;
        listPlace = new ArrayList<>();
        createListPlace();
    }

    private void createListPlace() {
        for (int i = 1; i <= COUNT_PLACE;) {
            listPlace.add(new Place(i++ , TypePassengerPlace.DOWN_PLACE));
            listPlace.add(new Place(i++ , TypePassengerPlace.DOWN_PLACE));
            listPlace.add(new Place(i++ , TypePassengerPlace.UP_PLACE));
            listPlace.add(new Place(i++ , TypePassengerPlace.UP_PLACE));
        }
//
    }


    public int getCountBusyPlace() {
        return countBusyPlace;
    }

    public void setCountBusyPlace(int countBusyPlace) {
        this.countBusyPlace = countBusyPlace;
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
