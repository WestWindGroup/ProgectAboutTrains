package ua.com.westwind.project.model.trainfactory;

import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

public class TrainDataProcessing {
    private String pathFile;
    private String typeTrain;
    private final String BASE_ROUTES_PASSENGER_TRAINS = "resources\\passenger\\BaseRoutesPassengerTrains.xml";
    private final String BASE_ROUTES_FREIGHT_TRAINS = "resources\\passenger\\BaseRoutesFreightTrains.xml";

    public PassengerTrain routePassengerTrainInObjectTrain(String route){
        returnDataAboutTrain(route,BASE_ROUTES_PASSENGER_TRAINS);
        return returnPassengerTrain().createTrain(route);
    }

    public FreightTrain routeFreightTrainInObjectTrain(String route){
        returnDataAboutTrain(route,BASE_ROUTES_FREIGHT_TRAINS);
        return returnFreightTrain().createTrain(route);
    }

    private PassengerTrainFactory returnPassengerTrain(){
        if(typeTrain.equals("CompositionPassengerTrain")){
            return new CompositionPassengerTrainFactory(pathFile);
        }else if(typeTrain.equals("IntercityTrain")){
            return new IntercityPassengerTrainFactory(pathFile);
        }
        return null;
    }

    private FreightTrainFactory returnFreightTrain() {
        if(typeTrain.equals("CompositionFreightTrain")){
            return new CompositionFreightTrainFactory(pathFile);
        }
        return null;
    }

    private void returnDataAboutTrain(String route, String fileBase){

        typeTrain = XMLFileParsing.returnDataAboutTrain(route,fileBase,"typeTrain");
        pathFile = XMLFileParsing.returnDataAboutTrain(route,fileBase,"file");

    }

    public int countBusyPlacesInTrain(PassengerTrain train){
        int countPasseger = 0;
        for (PassengerWagon passengerW:train.getListWagons()) {
            countPasseger += passengerW.getCountBusyPlace();
        }
        return countPasseger;
    }

    public double countAllMassBaggegeInTrain(PassengerTrain train){
        double allMassBaggege = 0;
        for (PassengerWagon passengerW:train.getListWagons()) {
            allMassBaggege += passengerW.getAllMassBaggege();
        }
        return allMassBaggege;
    }

    public ArrayList<PassengerWagon> searchWagonByCountPassengers(PassengerTrain train,
                                                                  int minCountPassengers,
                                                                  int maxCountPassengers){
        ArrayList<PassengerWagon> listW = new ArrayList<>();
        for (PassengerWagon wagon:train.getListWagons()) {
            if((wagon.getCountBusyPlace() >= minCountPassengers)&&(wagon.getCountBusyPlace() <= maxCountPassengers)){
                listW.add(wagon);
            }
        }
        if(listW.size() != 0){
            return listW;
        }
        else {
            return null;
        }
    }

}
