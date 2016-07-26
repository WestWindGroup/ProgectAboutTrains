package ua.com.westwind.project.model.passenger;

public class Passenger {

    private final Ticket TICKET;
    private Baggage baggage;

    public Passenger(Ticket TICKET) {
        this.TICKET = TICKET;
    }

    public Passenger(Ticket TICKET, Baggage baggage) {
        this.TICKET = TICKET;
        this.baggage = baggage;
    }

    public Ticket getTICKET() {
        return TICKET;
    }

    public Baggage getBaggage() {
        return baggage;
    }

    @Override
    public String toString() {
        String str = String.format("|  %9s  |", "Passenger");
        return str + TICKET +  baggage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (!TICKET.equals(passenger.TICKET)) return false;
        return baggage.equals(passenger.baggage);

    }

    @Override
    public int hashCode() {
        int result = TICKET.hashCode();
        result = 31 * result + (baggage != null ? baggage.hashCode() : 0);
        return result;
    }
}
