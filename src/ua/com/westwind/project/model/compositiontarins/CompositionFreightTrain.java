package ua.com.westwind.project.model.compositiontarins;

import ua.com.westwind.project.model.Locomotives;
import ua.com.westwind.project.model.Wagons;
import ua.com.westwind.project.model.wagons.freightwagons.FreightWagon;

import java.util.ArrayList;

public class CompositionFreightTrain extends CompositionTrain{
    private final String TYPE_TRAIN = "CompositionFreightTrain";

    public CompositionFreightTrain(ArrayList<Locomotives> listLocomotives,
                                     ArrayList<FreightWagon> freightWagons) {
        this.listWagons = freightWagons;
        this.listLocomotives = listLocomotives;
    }

    @Override
    public String returnTypeTrain() {
        return TYPE_TRAIN;
    }

    @Override
    public void showTrain() {
        for (Locomotives locomotive: listLocomotives) {
            System.out.println(locomotive);
        }
        for (Wagons wagon: listWagons) {
            System.out.println(wagon);
        }
    }
}
