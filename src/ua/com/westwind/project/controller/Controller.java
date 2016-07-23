package ua.com.westwind.project.controller;

import ua.com.westwind.project.model.trainfactory.PassengerTrains;
import ua.com.westwind.project.model.trainfactory.TrainDataProcessing;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;
import ua.com.westwind.project.view.View;

import java.util.*;

public class Controller extends View{

    Map<String,PassengerTrains> mapPassengerTrains = new HashMap<>();
    TrainDataProcessing trainDataProcessing = new TrainDataProcessing();

    public void createPassengerTrainFromBase(String route) {

        PassengerTrains train = trainDataProcessing.routePassengerTrainInObjectTrain(route);
        mapPassengerTrains.put(route,train);
    }
    public void showPassengerTrain(String route){
        showTrainInConsole(mapPassengerTrains.get(route));
    }

    public void getInPassengerTrainCountPassenger(String route){
        int countPassenger = trainDataProcessing.countBusyPlacesInTrain(mapPassengerTrains.get(route));
        String str = "In train " + route + " " + countPassenger + " passengers";
        showString(str);
    }

    public void getInPassengerTrainAllMassBaggege(String route){
        double allMassBaggege = trainDataProcessing.countAllMassBaggegeInTrain(mapPassengerTrains.get(route));
        String format = String.format(" %.2f",allMassBaggege);
        String str = "In train " + route + " all mass a baggage" + format + " kg";
        showString(str);
    }

    public void sortPassengerTrainOfComfort(String route){
        PassengerTrains train = mapPassengerTrains.get(route);
        ArrayList<PassengerWagon> listPW = (ArrayList<PassengerWagon>)train.getListPassengerWagon().clone();
        Collections.sort(listPW);
        System.out.println(listPW);
    }
}
