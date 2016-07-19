package ua.com.westwind.project.model.wagons.passengerwagons;

public class CoupeWagonWithSeating extends PassengerWagon {
    public static final TypePassengerWagon TYPE_WAGON = TypePassengerWagon.COUPE_WAGON_WITH_SEATING;
    private static final int COUNT_PLACE = 42;

    public CoupeWagonWithSeating() {
        super(TYPE_WAGON, COUNT_PLACE);
    }
}
