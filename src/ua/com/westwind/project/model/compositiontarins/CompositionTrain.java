package ua.com.westwind.project.model.compositiontarins;

import ua.com.westwind.project.model.Locomotives;
import ua.com.westwind.project.model.Train;
import ua.com.westwind.project.model.Wagons;

import java.util.ArrayList;

public class CompositionTrain implements Train {
    ArrayList<Locomotives>listLocomotives;
    ArrayList<Wagons>listWagons;
}
