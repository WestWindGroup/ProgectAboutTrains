package ua.com.westwind.project.model.compositiontarins;

import ua.com.westwind.project.model.Locomotives;
import ua.com.westwind.project.model.Train;
import ua.com.westwind.project.model.Wagons;

import java.util.ArrayList;

public abstract class CompositionTrain implements Train {

    protected ArrayList<? extends Locomotives> listLocomotives;
    protected ArrayList<? extends Wagons> listWagons;


}
