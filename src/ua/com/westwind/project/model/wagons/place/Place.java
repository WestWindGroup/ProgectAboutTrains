package ua.com.westwind.project.model.wagons.place;


public class Place {
    private int numberPlace;
    private TypePlace typePlace;
    private boolean busy;

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

    public boolean isBusy() {
        return busy;
    }

    public void setBusy(boolean busy) {
        this.busy = busy;
    }



    @Override
    public String toString() {
        return "\nPlace : " +
                "numberPlace = " + numberPlace +
                ", typePlace = " + typePlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Place place = (Place) o;

        if (numberPlace != place.numberPlace) return false;
        return typePlace != null ? typePlace.equals(place.typePlace) : place.typePlace == null;

    }

    @Override
    public int hashCode() {
        int result = numberPlace;
        result = 31 * result + (typePlace != null ? typePlace.hashCode() : 0);
        return result;
    }
}
