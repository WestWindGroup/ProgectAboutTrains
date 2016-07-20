package ua.com.westwind.project.model.wagons.passengerwagons;

public enum TypeIntercityPlace implements TypePlace{

    SEAT_PLACE_1_CLASS(1),
    SEAT_PLACE_2_CLASS(2);

    private int featuresPlace;

    TypeIntercityPlace(int featuresPlace){
        this.featuresPlace = featuresPlace;
    }

    public int getFeaturesPlace() {
        return featuresPlace;
    }
}
