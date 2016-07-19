package ua.com.westwind.project.model.wagons.passengerwagons;

public class CoupeNormalWagon extends PassengerWagon {

    public static final TypePassengerWagon TYPE_WAGON = TypePassengerWagon.COUPE;
    private static final int COUNT_PLACE = 40;

    public CoupeNormalWagon() {
        super(TYPE_WAGON, COUNT_PLACE);
    }
}
