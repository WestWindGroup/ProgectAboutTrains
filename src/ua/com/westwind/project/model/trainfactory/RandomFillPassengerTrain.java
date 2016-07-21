package ua.com.westwind.project.model.trainfactory;

import ua.com.westwind.project.model.compositiontarins.Baggage;
import ua.com.westwind.project.model.compositiontarins.Passenger;
import ua.com.westwind.project.model.compositiontarins.Ticket;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.RandomAccess;

public class RandomFillPassengerTrain {

    private double maxMassBaggage = 36;

    public ArrayList<Passenger> fillPassengers(List<PassengerWagon> listWagon){
        Random random = new Random();
        ArrayList<Passenger> listPassenger = new ArrayList<>();

        for (int i = 0; i < listWagon.size(); i++) {
            for (int j = 0; j < listWagon.get(i).getListPlace().size(); j++) {
                if(random.nextBoolean()){
                    Passenger passenger = new Passenger(new Ticket(i,j),new Baggage(Math.random() * maxMassBaggage));
                    listPassenger.add(passenger);
                }
            }
        }
        return listPassenger;
    }

    public double getMaxMassBaggage() {
        return maxMassBaggage;
    }

    public void setMaxMassBaggage(double maxMassBaggage) {
        this.maxMassBaggage = maxMassBaggage;
    }
}
