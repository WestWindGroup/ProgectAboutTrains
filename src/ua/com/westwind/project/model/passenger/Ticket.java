package ua.com.westwind.project.model.passenger;

public class Ticket {
    private final String route;
    private final int numberWagon;
    private final int numberPlace;

    public Ticket(String route,int numberWagon, int numberPlace) {
        this.route = route;
        this.numberWagon = numberWagon;
        this.numberPlace = numberPlace;
    }
    public String getRoute() {
        return route;
    }

    public int getNumberWagon() {
        return numberWagon;
    }

    public int getNumberPlace() {
        return numberPlace;
    }


    @Override
    public String toString() {
        String strTicket = String.format("| %10s","Ticket : ");
        String strNumberWagon = String.format("%14s","number wagon = ");
        String strNumeralWagon = String.format("%2s ,",numberWagon);
        String strNumberPlace = String.format("%15s"," number place = ");
        String strNumeralPlace = String.format("%3s  |",numberPlace);

        return strTicket + strNumberWagon + strNumeralWagon + strNumberPlace + strNumeralPlace;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Ticket ticket = (Ticket) o;

        if (numberWagon != ticket.numberWagon) return false;
        if (numberPlace != ticket.numberPlace) return false;
        return route != null ? route.equals(ticket.route) : ticket.route == null;

    }

    @Override
    public int hashCode() {
        int result = route != null ? route.hashCode() : 0;
        result = 31 * result + numberWagon;
        result = 31 * result + numberPlace;
        return result;
    }
}
