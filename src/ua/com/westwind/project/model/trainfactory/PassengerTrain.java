package ua.com.westwind.project.model.trainfactory;

import ua.com.westwind.project.model.passenger.Passenger;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

public interface PassengerTrain extends Train  {

    ArrayList<Passenger> getListPassengers();

    ArrayList<PassengerWagon> getListWagons();

    default void showHeadTrain() {
        System.out.println("\n" + getTypeTrain() + " ---- " + "route \"" + getRoute() + "\"\n");
    }

    default void showWagon(){
        for(int i = 0; i < getListWagons().size(); i++){
            System.out.println(getListWagons().get(i));
            System.out.println();
            for (Passenger passenger: getListPassengers()) {
                if(passenger.getTICKET().getNUMBER_WAGON() == i + 1){
                    System.out.println(passenger);
                }
            }
        }
    }
}
