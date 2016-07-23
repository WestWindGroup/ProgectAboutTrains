package ua.com.westwind.project.view;

import ua.com.westwind.project.model.trainfactory.Train;

public abstract class View {

    protected void showTrainInConsole(Train train) {
        train.showTrain();
    }
    protected void showString(String str) {
        System.out.println(str);
    }


}
