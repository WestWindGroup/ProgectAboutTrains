package ua.com.westwind.project.model.wagons.passengerwagons;

import java.util.ArrayList;

public class CoupeSVWagon extends PassengerWagon {

    private final PassengerTypeWagon TYPE_WAGON = PassengerTypeWagon.COUPE_SV;
    private final int COUNT_PLACE = 20;

    public CoupeSVWagon() {
        typeWagon = TYPE_WAGON;
        countPlace = COUNT_PLACE;
        listPlace = new ArrayList<>();
        createListPlace();
    }

    private void createListPlace() {
        for (int i = 1; i <= COUNT_PLACE;) {
            listPlace.add(new Place(i++ , TypePassengerPlace.DOWN_PLACE));
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
