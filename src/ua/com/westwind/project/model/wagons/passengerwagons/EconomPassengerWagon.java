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
        listPlace = new ArrayList<>();
        createListPlace();
    }

    private void createListPlace() {
        int countDownAndUpNormal = COUNT_PLACE_UP + COUNT_PLACE_DOWN;
        int i = 1;
        for (; i <= countDownAndUpNormal;) {
            listPlace.add(new Place(i++ , TypePassengerPlace.DOWN_PLACE));
            listPlace.add(new Place(i++ , TypePassengerPlace.DOWN_PLACE));
            listPlace.add(new Place(i++ , TypePassengerPlace.UP_PLACE));
            listPlace.add(new Place(i++ , TypePassengerPlace.UP_PLACE));
        }
        for (; i <= COUNT_PLACE;) {
            listPlace.add(new Place(i++ , TypePassengerPlace.SIDE_PLACE_DOWN));
            listPlace.add(new Place(i++ , TypePassengerPlace.SIDE_PLACE_UP));
        }
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
