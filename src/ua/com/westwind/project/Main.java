package ua.com.westwind.project;


import ua.com.westwind.project.controller.Controller;
import ua.com.westwind.project.model.trainfactory.Train;
import ua.com.westwind.project.model.trainfactory.TrainDataProcessing;

public class Main {

    public static void main(String[] args) {
        //Kharkov-Odessa  Lviv-Kiev  "Poltava-Kharkov"

        Controller controller = new Controller();
//        controller.createPassengerTrainFromBase("Kharkov-Odessa");//"Kharkov-Odessa" "Lviv-Kiev"
//        controller.showPassengerTrain("Kharkov-Odessa");
//        controller.getInPassengerTrainCountPassenger("Kharkov-Odessa");
//        controller.getInPassengerTrainAllMassBaggege("Kharkov-Odessa");
//        controller.sortPassengerTrainOfComfort("Kharkov-Odessa");

//        controller.createPassengerTrainFromBase("Lviv-Kiev");//"Kharkov-Odessa" "Lviv-Kiev" "Poltava-Kharkov"
//        controller.showPassengerTrain("Lviv-Kiev");
//        controller.getInPassengerTrainCountPassenger("Lviv-Kiev");
//        controller.getInPassengerTrainAllMassBaggege("Lviv-Kiev");
//        controller.sortPassengerTrainOfComfort("Lviv-Kiev");

//        controller.createPassengerTrainFromBase("Poltava-Kharkov");//"Kharkov-Odessa" "Lviv-Kiev" "Poltava-Kharkov"
//        controller.showPassengerTrain("Poltava-Kharkov");
//        controller.getInPassengerTrainCountPassenger("Poltava-Kharkov");
//        controller.getInPassengerTrainAllMassBaggege("Poltava-Kharkov");
//        controller.sortPassengerTrainOfComfort("Poltava-Kharkov");

//        controller.createPassengerTrainFromBase("Lviv-Dnepr");//"Kharkov-Odessa" "Lviv-Kiev" "Poltava-Kharkov"
//        controller.showPassengerTrain("Lviv-Dnepr");
//        controller.getInPassengerTrainCountPassenger("Lviv-Dnepr");
//        controller.getInPassengerTrainAllMassBaggege("Lviv-Dnepr");
//        controller.sortPassengerTrainOfComfort("Lviv-Dnepr");
//        controller.searchWagonByCountPassengers("Lviv-Dnepr",10,34);
        controller.userInterface();
    }
}
