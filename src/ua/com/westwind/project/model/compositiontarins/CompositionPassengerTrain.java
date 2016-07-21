package ua.com.westwind.project.model.compositiontarins;

import ua.com.westwind.project.model.Locomotives;
import ua.com.westwind.project.model.Wagons;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

public class CompositionPassengerTrain extends CompositionTrain{
    private final String TYPE_TRAIN = "CompositionPassengerTrain";
    private ArrayList<Passenger> listPassengers;

    public CompositionPassengerTrain(ArrayList<Locomotives> listLocomotives,
                                     ArrayList<PassengerWagon> listWagons,
                                     ArrayList<Passenger> listPassengers) {
        this.listWagons = listWagons;
        this.listLocomotives = listLocomotives;
        this.listPassengers = listPassengers;
    }

    @Override
    public String returnTypeTrain() {
        return TYPE_TRAIN;
    }

    @Override
    public void showTrain() {
        for (Locomotives locomotive: listLocomotives) {
            System.out.println(locomotive);
        }
        for(int i = 0; i < listWagons.size(); i++){
            System.out.println(listWagons.get(i));
            for (Passenger passenger: listPassengers) {
                if(passenger.getTicket().getNumberWagon() == i + 1){
                    System.out.println(passenger);
                }
            }
        }
    }

}
