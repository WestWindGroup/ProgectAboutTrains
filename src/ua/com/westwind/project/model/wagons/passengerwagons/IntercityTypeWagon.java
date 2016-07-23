package ua.com.westwind.project.model.wagons.passengerwagons;

public enum IntercityTypeWagon implements TypeWagon {

    WAGON_1_CLASS(0),
    WAGON_1_AND_2_CLASSES(1),
    WAGON_2_CLASS(2);

    private int comfortLevel;

    IntercityTypeWagon(int comfortLevel){
        this.comfortLevel = comfortLevel;
    }

    public int getComfortLevel() {
        return comfortLevel;
    }
}
