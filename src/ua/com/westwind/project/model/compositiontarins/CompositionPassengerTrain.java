package ua.com.westwind.project.model.compositiontarins;

import ua.com.westwind.project.model.Locomotives;
import ua.com.westwind.project.model.Wagons;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

public class CompositionPassengerTrain extends CompositionTrain{

    private ArrayList<Passenger> listPassengers;

    public CompositionPassengerTrain(ArrayList<Locomotives> listLocomotives,
                                     ArrayList<PassengerWagon> passengerWagons,
                                     ArrayList<Passenger> listPassengers) {
        this.listWagons = passengerWagons;
        this.listLocomotives = listLocomotives;
        this.listPassengers = listPassengers;
    }

}
