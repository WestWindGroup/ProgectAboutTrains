package ua.com.westwind.project.model.wagons.place;

import ua.com.westwind.project.model.wagons.place.TypePlace;

public enum TypePassengerPlace implements TypePlace {

    SEAT_PLACE(0),
    DOWN_PLACE(1),
    UP_PLACE(2),
    SIDE_PLACE_UP(3),
    SIDE_PLACE_DOWN(4);

    private int featuresPlace;

    TypePassengerPlace(int featuresPlace){
        this.featuresPlace = featuresPlace;
    }

    public int getFeaturesPlace() {
        return featuresPlace;
    }
}
