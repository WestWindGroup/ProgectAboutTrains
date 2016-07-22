package ua.com.westwind.project.model.compositiontarins;

import ua.com.westwind.project.model.lokomotives.Locomotives;
import ua.com.westwind.project.model.wagons.Wagons;
import ua.com.westwind.project.model.wagons.freightwagons.FreightWagon;

import java.util.ArrayList;

public class CompositionFreightTrain extends CompositionTrain{

    private final String TYPE_TRAIN = "CompositionFreightTrain";

    public CompositionFreightTrain() {
    }

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

    @Override
    public String toString() {
        return "CompositionFreightTrain{" +
                "TYPE_TRAIN='" + TYPE_TRAIN + '\'' +
                ", listLocomotives =" + listLocomotives +
                ", listWagons = " + listWagons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompositionFreightTrain that = (CompositionFreightTrain) o;

        if (TYPE_TRAIN != null ? !TYPE_TRAIN.equals(that.TYPE_TRAIN) : that.TYPE_TRAIN != null) return false;
        if (listLocomotives != null ? !listLocomotives.equals(that.listLocomotives) : that.listLocomotives != null)
            return false;
        return listWagons != null ? listWagons.equals(that.listWagons) : that.listWagons == null;

    }

    @Override
    public int hashCode() {
        int result = TYPE_TRAIN != null ? TYPE_TRAIN.hashCode() : 0;
        result = 31 * result + (listLocomotives != null ? listLocomotives.hashCode() : 0);
        result = 31 * result + (listWagons != null ? listWagons.hashCode() : 0);
        return result;
    }
}
