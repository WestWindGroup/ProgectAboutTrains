package ua.com.westwind.project.model.compositiontarins;

public class Ticket {
    private final int numberWagon;
    private final int numberPlace;

    public Ticket(int numberWagon, int numberPlace) {
        this.numberWagon = numberWagon;
        this.numberPlace = numberPlace;
    }

    public int getNumberWagon() {
        return numberWagon;
    }

    public int getNumberPlace() {
        return numberPlace;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "numberWagon=" + numberWagon +
                ", numberPlace=" + numberPlace +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (numberWagon != ticket.numberWagon) return false;
        return numberPlace == ticket.numberPlace;

    }

    @Override
    public int hashCode() {
        int result = numberWagon;
        result = 31 * result + numberPlace;
        return result;
    }
}
