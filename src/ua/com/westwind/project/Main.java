package ua.com.westwind.project;


import ua.com.westwind.project.controller.Controller;
import ua.com.westwind.project.model.compositiontarins.CompositionPassengerTrain;
import ua.com.westwind.project.model.compositiontarins.CompositionTrain;
import ua.com.westwind.project.model.trainfactory.CompositionPassengerTrainFactory;
import ua.com.westwind.project.model.trainfactory.Train;
import ua.com.westwind.project.model.trainfactory.CreateTrain;

public class Main {

    public static void main(String[] args) {
//        List<IntercityTrains> intercityTrains = new ArrayList<>();
//        intercityTrains.add(new SkodaIntercityTrains());
//        intercityTrains.add(new TrainLocomotiveTraction());
//        intercityTrains.add(new TarpanIntercityTrains());
//        intercityTrains.add(new HyundaiIntercityTrains());
//        for (IntercityTrains help:intercityTrains) {
//            System.out.println(help);
//        }
        CreateTrain createTrain = new CreateTrain();

        Train train = createTrain.routeTrainInObjectTrain("LvivKiev");//KharkovOdessa  LvivKiev

        Controller controller = new Controller();
        controller.showTrainInConsole(train);
    }
}
