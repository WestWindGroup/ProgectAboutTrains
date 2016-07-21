package ua.com.westwind.project.view;

import ua.com.westwind.project.model.Train;

public abstract class View {

    public void showTrainInConsole(Train train) {
        train.showTrain();
    }


}
