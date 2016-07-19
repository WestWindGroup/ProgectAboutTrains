package ua.com.westwind.project.model.wagons.passengerwagons;

import java.util.ArrayList;

public class PassengerWagonWithSeating extends PassengerWagon {

    public static final TypeWagon TYPE_WAGON = TypeWagon.PASSENGER_WAGON_WITH_SEATING;
    private static final int COUNT_PLACE = 60;

    public PassengerWagonWithSeating() {
        super(TYPE_WAGON, COUNT_PLACE);
    }
}
