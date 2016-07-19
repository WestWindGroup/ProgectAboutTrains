package ua.com.westwind.project.model.wagons.passengerwagons;

public class Place {
    private int numberPlace;
    private TypePlace typePlace;

    public Place(int numberPlace, TypePlace typePlace) {
        this.numberPlace = numberPlace;
        this.typePlace = typePlace;
    }

    public TypePlace getTypePlace() {
        return typePlace;
    }

    public void setTypePlace(TypePlace typePlace) {
        this.typePlace = typePlace;
    }

    public int getNumberPlace() {
        return numberPlace;
    }

    public void setNumberPlace(int numberPlace) {
        this.numberPlace = numberPlace;
    }


}
