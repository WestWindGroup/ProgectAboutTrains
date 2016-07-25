package ua.com.westwind.project.model.compositiontarins;

import ua.com.westwind.project.model.lokomotives.Locomotives;

import java.util.ArrayList;

public abstract class CompositionTrain{

    public abstract ArrayList<Locomotives> getListLocomotives();

    public abstract void setListLocomotives(ArrayList<Locomotives> listLocomotives);
}
