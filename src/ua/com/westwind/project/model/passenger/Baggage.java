package ua.com.westwind.project.model.passenger;

public class Baggage{

    private double massBaggage;
    private String formattedDouble;
    private final String route;
    private final int numberWagon;
    private final int numberPlace;

    public Baggage(double massBaggage,Ticket ticket) {
        this.massBaggage = massBaggage;
        formattedDouble = String.format("%.2f", this.massBaggage);
        numberPlace = ticket.getNumberPlace();
        numberWagon = ticket.getNumberWagon();
        route = ticket.getRoute();
    }

    public double getMassBaggage() {
        return massBaggage;
    }

    @Override
    public String toString() {

        String strBaggage = String.format("%12s","| Baggage : ");
        String strMassBaggage = String.format("%14s","mass baggage = ");
        String strMassBaggageNum = String.format("%5s |",formattedDouble);

        return strBaggage + strMassBaggage + strMassBaggageNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Baggage baggage = (Baggage) o;

        if (Double.compare(baggage.massBaggage, massBaggage) != 0) return false;
        if (numberWagon != baggage.numberWagon) return false;
        if (numberPlace != baggage.numberPlace) return false;
        return route != null ? route.equals(baggage.route) : baggage.route == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(massBaggage);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (route != null ? route.hashCode() : 0);
        result = 31 * result + numberWagon;
        result = 31 * result + numberPlace;
        return result;
    }
}
