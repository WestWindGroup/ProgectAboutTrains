package ua.com.westwind.project.model.compositiontarins;

public class Passenger {

    private final Ticket ticket;
    private final Baggage baggage;

    public Passenger(Ticket ticket, Baggage baggage) {
        this.ticket = ticket;
        this.baggage = baggage;
    }


    public Ticket getTicket() {
        return ticket;
    }


    public Baggage getBaggage() {
        return baggage;
    }


    @Override
    public String toString() {
        return "Passenger -> " + ticket +
                "," + baggage;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (!ticket.equals(passenger.ticket)) return false;
        return baggage.equals(passenger.baggage);

    }

    @Override
    public int hashCode() {
        int result = ticket.hashCode();
        result = 31 * result + baggage.hashCode();
        return result;
    }
}
