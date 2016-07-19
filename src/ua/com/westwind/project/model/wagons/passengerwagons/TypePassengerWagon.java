package ua.com.westwind.project.model.wagons.passengerwagons;

public enum TypePassengerWagon {
    COUPE_SV(0),
    COUPE(1),
    ECONOM_PASSENGER_WAGON(2),
    COUPE_WAGON_WITH_SEATING(3),
    PASSENGER_WAGON_WITH_SEATING(4);

    private int comfortLevel;

    TypePassengerWagon(int comfortLevel){
        this.comfortLevel = comfortLevel;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }

}
