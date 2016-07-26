package ua.com.westwind.project.model.trainfactory;

import ua.com.westwind.project.model.lokomotives.Locomotives;
import ua.com.westwind.project.model.wagons.Wagons;
import ua.com.westwind.project.model.wagons.freightwagons.FreightWagon;

import java.util.ArrayList;

public interface FreightTrain extends Train {

    ArrayList<Locomotives> getListLocomotives();
    void setListLocomotives(ArrayList<Locomotives> listLocomotives);
    ArrayList<FreightWagon> getListWagons();
    void setListWagons(ArrayList<FreightWagon> listWagons);

    default void showHeadTrain() {
        System.out.println(getTypeTrain() + " ---- " + "route " + "\"" + getRoute() + "\"");
    }

    default void showTrain() {
        showHeadTrain();
        for (Locomotives locomotive: getListLocomotives()) {
            System.out.println(locomotive);
        }
        for (Wagons wagon: getListWagons()) {
            System.out.println(wagon);
        }
    }

}
