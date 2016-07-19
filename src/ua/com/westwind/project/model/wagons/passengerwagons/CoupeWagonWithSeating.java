package ua.com.westwind.project.model.wagons.passengerwagons;

public class CoupeWagonWithSeating extends PassengerWagon {
    public static final TypeWagon TYPE_WAGON = TypeWagon.COUPE_WAGON_WITH_SEATING;
    private static final int COUNT_PLACE = 42;

    public CoupeWagonWithSeating() {
        super(TYPE_WAGON, COUNT_PLACE);
    }
}
