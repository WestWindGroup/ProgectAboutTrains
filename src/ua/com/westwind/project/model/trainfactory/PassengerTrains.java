package ua.com.westwind.project.model.trainfactory;

import ua.com.westwind.project.model.passenger.Passenger;
import ua.com.westwind.project.model.wagons.Wagons;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

public interface PassengerTrains extends Train  {

    ArrayList<Passenger> getListPassengers();

    ArrayList<PassengerWagon> getListWagons();

    default void showWagon(){
        for(int i = 0; i < getListWagons().size(); i++){
            System.out.println(getListWagons().get(i));
            printLine();
            for (Passenger passenger: getListPassengers()) {
                if(passenger.getTicket().getNumberWagon() == i + 1){
                    System.out.println(passenger);
                }
            }
            printLine();
        }
    }
}
