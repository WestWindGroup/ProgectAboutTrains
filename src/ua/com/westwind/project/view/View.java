package ua.com.westwind.project.view;

import ua.com.westwind.project.model.trainfactory.Train;
import ua.com.westwind.project.model.wagons.Wagons;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;
import java.util.Map;
import java.util.Set;

public abstract class View {

    protected void showTrainInConsole(Train train) {
        train.showTrain();
    }

    protected void showHeadTrainInConsole(Train train) {
        printLine();
        train.showHeadTrain();
        printLine();
    }

    protected void showString(String str) {
        System.out.println(str);
    }

    protected void showPassengerWagonList(ArrayList<? extends Wagons> listPW) {
        System.out.println(listPW);
    }

    protected void showMapList(Map<Integer,String> map) {
        Set<Map.Entry<Integer,String>> set = map.entrySet();
        for (Map.Entry<Integer,String> setHelpIter : set) {
            System.out.println(setHelpIter.getKey() + ". " + setHelpIter.getValue());
        }
    }

    protected void printLine(){
        for (int i = 0; i < 100; i++) {
            System.out.print("-");
            if(i == 99)
            {
                System.out.print("\n");
            }
        }
    }


}
