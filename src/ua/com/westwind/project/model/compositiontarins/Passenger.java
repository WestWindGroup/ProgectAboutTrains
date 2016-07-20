package ua.com.westwind.project.model.compositiontarins;

public class Passenger {

    private final Tickets tickets;
    private final Baggage baggage;

    public Passenger(Tickets tickets, Baggage baggage) {
        this.tickets = tickets;
        this.baggage = baggage;
    }


    public Tickets getTickets() {
        return tickets;
    }


    public Baggage getBaggage() {
        return baggage;
    }


    @Override
    public String toString() {
        return "Passenger{" +
                "tickets = " + tickets +
                ", baggage = " + baggage +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Passenger passenger = (Passenger) o;

        if (!tickets.equals(passenger.tickets)) return false;
        return baggage.equals(passenger.baggage);

    }

    @Override
    public int hashCode() {
        int result = tickets.hashCode();
        result = 31 * result + baggage.hashCode();
        return result;
    }
}
