package ua.com.westwind.project.model.wagons.passengerwagons;

public class EconomPassengerWagon extends PassengerWagon {
    public static final TypePassengerWagon TYPE_WAGON = TypePassengerWagon.ECONOM_PASSENGER_WAGON;
    private static final int COUNT_PLACE = 54;

    public EconomPassengerWagon() {
        super(TYPE_WAGON, COUNT_PLACE);
    }
}
