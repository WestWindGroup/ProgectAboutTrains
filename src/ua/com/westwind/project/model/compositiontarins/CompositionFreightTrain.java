package ua.com.westwind.project.model.compositiontarins;

import ua.com.westwind.project.model.lokomotives.Locomotives;
import ua.com.westwind.project.model.trainfactory.FreightTrain;
import ua.com.westwind.project.model.wagons.freightwagons.FreightWagon;

import java.util.ArrayList;

public class CompositionFreightTrain implements FreightTrain {

    private String route;
    private final String TYPE_TRAIN = "CompositionFreightTrain";
    private ArrayList<Locomotives> listLocomotives;
    private ArrayList<FreightWagon> listWagons;

    public CompositionFreightTrain() {
    }

    public CompositionFreightTrain(ArrayList<Locomotives> listLocomotives,
                                     ArrayList<FreightWagon> freightWagons) {
        this.listWagons = freightWagons;
        this.listLocomotives = listLocomotives;
    }


    public String getRoute() {
        return route;
    }

    public void setRoute(String route) {
        this.route = route;
    }

    public ArrayList<Locomotives> getListLocomotives() {
        return listLocomotives;
    }

    public void setListLocomotives(ArrayList<Locomotives> listLocomotives) {
        this.listLocomotives = listLocomotives;
    }

    public ArrayList<FreightWagon> getListWagons() {
        return listWagons;
    }

    public void setListWagons(ArrayList<FreightWagon> listWagons) {
        this.listWagons = listWagons;
    }


    @Override
    public String getTypeTrain() {
        return TYPE_TRAIN;
    }

    @Override
    public String toString() {
        return "" + TYPE_TRAIN +
                " listLocomotives = " + listLocomotives +
                " listWagons = " + listWagons;
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
