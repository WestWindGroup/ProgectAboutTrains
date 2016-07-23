package ua.com.westwind.project.model.trainfactory;

import ua.com.westwind.project.model.passenger.Passenger;
import ua.com.westwind.project.model.wagons.Wagons;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

public interface PassengerTrains extends Train  {

    ArrayList<Passenger> getListPassengers();
    ArrayList<PassengerWagon> getListPassengerWagon();
}
