package ua.com.westwind.project.model.wagons.passengerwagons;

import ua.com.westwind.project.model.wagons.place.Place;
import ua.com.westwind.project.model.wagons.place.TypeIntercityPlace;

import java.util.ArrayList;

public class IntercityWagon extends PassengerWagon {

    private final int countPlaceFirstClass;
    private final int countPlaceSecondClass;

    public IntercityWagon(IntercityTypeWagon typeWagon, int countPlaceFirstClass, int countPlaceSecondClass) {
        this.typeWagon = typeWagon;
        this.countPlaceFirstClass = countPlaceFirstClass;
        this.countPlaceSecondClass = countPlaceSecondClass;
        this.countPlace = countPlaceFirstClass + countPlaceSecondClass;
        listPlace = new ArrayList<>(countPlace);
        createListPlace();
    }

    private void createListPlace() {
        for (int i = 1; i <= countPlaceFirstClass;) {
            listPlace.add(new Place(i++ , TypeIntercityPlace.SEAT_PLACE_1_CLASS));
        }
        for (int i = countPlaceFirstClass + 1; i <= countPlaceFirstClass + countPlaceSecondClass; i++) {
            listPlace.add(new Place(i , TypeIntercityPlace.SEAT_PLACE_2_CLASS));
        }
    }


    public int getCountPlaceFirstClass() {
        return countPlaceFirstClass;
    }

    public int getCountPlaceSecondClass() {
        return countPlaceSecondClass;
    }

}
