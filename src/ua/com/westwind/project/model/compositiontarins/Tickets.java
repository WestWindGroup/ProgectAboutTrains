package ua.com.westwind.project.model.compositiontarins;

public class Tickets {
    private final int numberWagon;
    private final int numberPlace;
    private final double valueTicket;

    public Tickets(int numberWagon, int numberPlace, double valueTicket) {
        this.numberWagon = numberWagon;
        this.numberPlace = numberPlace;
        this.valueTicket = valueTicket;
    }

    public int getNumberWagon() {
        return numberWagon;
    }

    public int getNumberPlace() {
        return numberPlace;
    }

    public double getValueTicket() {
        return valueTicket;
    }

    @Override
    public String toString() {
        return "Tickets{" +
                "numberWagon = " + numberWagon +
                ", numberPlace = " + numberPlace +
                ", valueTicket = " + valueTicket +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Tickets tickets = (Tickets) o;

        if (numberWagon != tickets.numberWagon) return false;
        if (numberPlace != tickets.numberPlace) return false;
        return Double.compare(tickets.valueTicket, valueTicket) == 0;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = numberWagon;
        result = 31 * result + numberPlace;
        temp = Double.doubleToLongBits(valueTicket);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }
}
