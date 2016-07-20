package ua.com.westwind.project.model.wagons.passengerwagons;

public enum TypePassendgerPlace implements TypePlace{

    SEAT_PLACE(0),
    DOWN_PLACE(1),
    UP_PLACE(2),
    SIDE_PLACE(3);

    private int featuresPlace;

    TypePassendgerPlace(int featuresPlace){
        this.featuresPlace = featuresPlace;
    }

    public int getFeaturesPlace() {
        return featuresPlace;
    }
}
