package ua.com.westwind.project.model.wagons.passengerwagons;

public class PassengerWagonWithSeating extends PassengerWagon {

    public static final TypePassengerWagon TYPE_WAGON = TypePassengerWagon.PASSENGER_WAGON_WITH_SEATING;
    private static final int COUNT_PLACE = 60;

    public PassengerWagonWithSeating() {
        super(TYPE_WAGON, COUNT_PLACE);
    }
}
