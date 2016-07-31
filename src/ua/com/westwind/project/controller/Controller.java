package ua.com.westwind.project.controller;

import ua.com.westwind.project.model.trainfactory.PassengerTrain;
import ua.com.westwind.project.model.trainfactory.TrainDataProcessing;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;
import ua.com.westwind.project.view.View;

import java.util.*;

public class Controller extends View {

    private int numCreateTrainInList;
    private Map<Integer, String> mapListTrains = new HashMap<>();
    private Map<Integer, String> mapListCreateTrains = new HashMap<>();
    private Map<Integer, String> mapListActionsOnTrain = new HashMap<>();
    private Map<String, PassengerTrain> mapCreatePassengerTrains = new HashMap<>();
    private TrainDataProcessing trainDataProcessing = new TrainDataProcessing();
    private PassengerTrain train;
    private Scanner scanner = new Scanner(System.in);
    private UserScreen user;

    public void startProgramm(){
        try{
            user = new UserScreen();
            user.userInterface(scanner);
        }finally {
            scanner.close();
        }

    }

    public Map<String, PassengerTrain> getMapCreatePassengerTrains() {
        return mapCreatePassengerTrains;
    }

    public PassengerTrain createPassengerTrainFromBase(String route) throws Exception {

        PassengerTrain train = trainDataProcessing.routePassengerTrainInObjectTrain(route);
        if (mapCreatePassengerTrains.put(route, train) == null) {
            numCreateTrainInList++;
            mapListCreateTrains.put(numCreateTrainInList, route);
        }
        return train;
    }

    public void showPassengerTrain(PassengerTrain train) {
        showTrainInConsole(train);
    }

    public void getInPassengerTrainCountPassenger(PassengerTrain train) throws Exception {
        int countPassenger = trainDataProcessing.countBusyPlacesInTrain(train);
        String str = "В поезде " + train.getRoute() + " " + countPassenger + " пассажиров";
        showString(str);
    }

    public void getInPassengerTrainAllMassBaggege(PassengerTrain train) throws Exception {
        double allMassBaggege = trainDataProcessing.countAllMassBaggegeInTrain(train);
        String format = String.format(" %.2f", allMassBaggege);
        String str = "В поезде " + train.getRoute() + " общее колличество баггажа" + format + " kg";
        showString(str);
    }

    public void sortPassengerTrainOfComfort(PassengerTrain train) throws Exception {
        ArrayList<PassengerWagon> listPW = (ArrayList<PassengerWagon>) train.getListWagons().clone();
        Collections.sort(listPW);
        showPassengerWagonList(listPW);
    }

    public void searchWagonByCountPassengers(PassengerTrain train,
                                              int minCountPassengers,
                                              int maxCountPassengers) throws Exception {
        ArrayList<PassengerWagon> listPW =
                trainDataProcessing.searchWagonByCountPassengers(train, minCountPassengers, maxCountPassengers);
        if (listPW != null) {
            showPassengerWagonList(listPW);
        } else {
            showString("Вагоны с колличеством пассажиров от " +
                    minCountPassengers + " до " + maxCountPassengers +
                    " отсутствуют\n");
        }

    }

    public PassengerTrain getTrain() {
        return train;
    }

    public void setTrain(PassengerTrain train) {
        this.train = train;
    }

    public Scanner getScanner() {
        return scanner;
    }


}
