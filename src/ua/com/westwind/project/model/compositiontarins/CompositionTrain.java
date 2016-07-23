package ua.com.westwind.project.model.compositiontarins;

import ua.com.westwind.project.model.lokomotives.Locomotives;
import ua.com.westwind.project.model.trainfactory.Train;
import ua.com.westwind.project.model.wagons.Wagons;

import java.util.ArrayList;

public abstract class CompositionTrain{

    protected ArrayList<? extends Locomotives> listLocomotives;
    protected ArrayList<? extends Wagons> listWagons;


}
