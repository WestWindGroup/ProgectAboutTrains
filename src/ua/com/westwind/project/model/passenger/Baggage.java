package ua.com.westwind.project.model.passenger;

public class Baggage{

    private double massBaggage;
    private final String ROUTE;
    private final int NUMBER_WAGON;
    private final int NUMBER_PLACE;

    public Baggage(double massBaggage,Ticket ticket) {
        this.massBaggage = massBaggage;
        NUMBER_PLACE = ticket.getNUMBER_PLACE();
        NUMBER_WAGON = ticket.getNUMBER_WAGON();
        ROUTE = ticket.getROUTE();
    }

    public double getMassBaggage() {
        return massBaggage;
    }

    public String getROUTE() {
        return ROUTE;
    }

    public int getNUMBER_WAGON() {
        return NUMBER_WAGON;
    }

    public int getNUMBER_PLACE() {
        return NUMBER_PLACE;
    }


    @Override
    public String toString() {
        String formattedDouble = String.format("%.2f", this.massBaggage);
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
        if (NUMBER_WAGON != baggage.NUMBER_WAGON) return false;
        if (NUMBER_PLACE != baggage.NUMBER_PLACE) return false;
        return ROUTE != null ? ROUTE.equals(baggage.ROUTE) : baggage.ROUTE == null;

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        temp = Double.doubleToLongBits(massBaggage);
        result = (int) (temp ^ (temp >>> 32));
        result = 31 * result + (ROUTE != null ? ROUTE.hashCode() : 0);
        result = 31 * result + NUMBER_WAGON;
        result = 31 * result + NUMBER_PLACE;
        return result;
    }
}
