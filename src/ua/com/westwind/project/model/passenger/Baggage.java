package ua.com.westwind.project.model.passenger;

public class Baggage {
    private double massBaggage;
    private String formattedDouble;

    public Baggage(double massBaggage) {
        this.massBaggage = massBaggage;
        formattedDouble = String.format("%.2f", this.massBaggage);
    }

    public double getMassBaggage() {
        return massBaggage;
    }

    @Override
    public String toString() {

        String strBaggage = String.format("%12s","| Baggage : ");
        String strMassBaggage = String.format("%14s","massBaggage = ");
        String strMassBaggageNum = String.format("%5s |",formattedDouble);

        return strBaggage + strMassBaggage + strMassBaggageNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Baggage baggage = (Baggage) o;

        return Double.compare(baggage.massBaggage, massBaggage) == 0;

    }

    @Override
    public int hashCode() {
        long temp = Double.doubleToLongBits(massBaggage);
        return (int) (temp ^ (temp >>> 32));
    }
}
