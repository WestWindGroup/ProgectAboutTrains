package ua.com.westwind.project.view;

import ua.com.westwind.project.model.trainfactory.Train;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

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

    protected void showMapList(Map<Integer,String> map) {
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        for (Map.Entry<Integer,String> setHelpIter : set) {
            System.out.println(setHelpIter.getKey() + ". " + setHelpIter.getValue());
        }
    }


}
