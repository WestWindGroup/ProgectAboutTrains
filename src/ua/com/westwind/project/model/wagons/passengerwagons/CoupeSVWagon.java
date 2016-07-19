package ua.com.westwind.project.model.wagons.passengerwagons;

public class CoupeSVWagon extends PassengerWagon {
    public static final TypePassengerWagon TYPE_WAGON = TypePassengerWagon.COUPE_SV;
    private static final int COUNT_PLACE = 20;

    public CoupeSVWagon() {
        super(TYPE_WAGON, COUNT_PLACE);
    }
}
