package ua.com.westwind.project.view;

import ua.com.westwind.project.model.trainfactory.Train;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

public abstract class View {

    protected void showTrainInConsole(Train train) {
        train.showTrain();
    }

    protected void showHeadTrainInConsole(Train train) {
        train.showHeadTrain();
    }

    protected void showString(String str) {
        System.out.println(str);
    }

    protected void showPassengerWagonList(ArrayList<PassengerWagon> listPW) {
        System.out.println(listPW);
    }


}
