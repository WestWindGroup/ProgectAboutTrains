package ua.com.westwind.project.model.passenger;

public class Ticket {

    private final String ROUTE;
    private final int NUMBER_WAGON;
    private final int NUMBER_PLACE;

    public Ticket(String ROUTE, int NUMBER_WAGON, int NUMBER_PLACE) {
        this.ROUTE = ROUTE;
        this.NUMBER_WAGON = NUMBER_WAGON;
        this.NUMBER_PLACE = NUMBER_PLACE;
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
        String strTicket = String.format("| %10s","Ticket : ");
        String strNumberWagon = String.format("%14s","number wagon = ");
        String strNumeralWagon = String.format("%2s ,", NUMBER_WAGON);
        String strNumberPlace = String.format("%15s"," number place = ");
        String strNumeralPlace = String.format("%3s  |", NUMBER_PLACE);

        return strTicket + strNumberWagon + strNumeralWagon + strNumberPlace + strNumeralPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (NUMBER_WAGON != ticket.NUMBER_WAGON) return false;
        if (NUMBER_PLACE != ticket.NUMBER_PLACE) return false;
        return ROUTE != null ? ROUTE.equals(ticket.ROUTE) : ticket.ROUTE == null;

    }

    @Override
    public int hashCode() {
        int result = ROUTE != null ? ROUTE.hashCode() : 0;
        result = 31 * result + NUMBER_WAGON;
        result = 31 * result + NUMBER_PLACE;
        return result;
    }
}
