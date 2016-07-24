package ua.com.westwind.project.model.compositiontarins;

import ua.com.westwind.project.model.lokomotives.Locomotives;
import ua.com.westwind.project.model.passenger.Passenger;
import ua.com.westwind.project.model.trainfactory.FreightTrains;
import ua.com.westwind.project.model.trainfactory.PassengerTrains;
import ua.com.westwind.project.model.wagons.Wagons;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

public class CompositionPassengerTrain extends CompositionTrain implements PassengerTrains {

    private final String TYPE_TRAIN = "CompositionPassengerTrain";
    private ArrayList<Passenger> listPassengers;
    private ArrayList<Locomotives> listLocomotives;
    private ArrayList<PassengerWagon> listWagons;

    private String route;

    public CompositionPassengerTrain(){
    }

    public CompositionPassengerTrain(ArrayList<Locomotives> listLocomotives,
                                     ArrayList<PassengerWagon> listWagons) {
        this.listWagons = listWagons;
        this.listLocomotives = listLocomotives;
    }

    public CompositionPassengerTrain(String route, ArrayList<Locomotives> listLocomotives,
                                     ArrayList<PassengerWagon> listWagons,
                                     ArrayList<Passenger> listPassengers) {
        this.route = route;
        this.listWagons = listWagons;
        this.listLocomotives = listLocomotives;
        this.listPassengers = listPassengers;
    }

    @Override
    public String returnTypeTrain() {
        return TYPE_TRAIN;
    }

    @Override
    public void showTrain() {
        showHeadTrain();
        for (Locomotives locomotive: listLocomotives) {
            System.out.println(locomotive);
        }
        printLine();
        for(int i = 0; i < listWagons.size(); i++){
            System.out.println(listWagons.get(i));
            printLine();
            for (Passenger passenger: listPassengers) {
                if(passenger.getTicket().getNumberWagon() == i + 1){
                    System.out.println(passenger);
                }
            }
            printLine();
        }
    }

    @Override
    public void showHeadTrain() {
        printLine();
        System.out.println("CompositionPassengerTrain ---- " + "route " + "\"" + route + "\"");
        printLine();
    }

    private void printLine(){
        System.out.println("---------------------------------------------------------------------------------------------------");
    }


    public String getRoute() {
        return route;
    }


    public ArrayList<Passenger> getListPassengers() {
        return listPassengers;
    }

    @Override
    public ArrayList<PassengerWagon> getListPassengerWagon() {
        return listWagons;
    }


    @Override
    public String toString() {
        return "CompositionPassengerTrain\n" +
                ", listPassengers=" + listPassengers +
                ", listLocomotives=" + listLocomotives +
                ", listWagons=" + listWagons +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CompositionPassengerTrain that = (CompositionPassengerTrain) o;

        if (TYPE_TRAIN != null ? !TYPE_TRAIN.equals(that.TYPE_TRAIN) : that.TYPE_TRAIN != null) return false;
        if (listPassengers != null ? !listPassengers.equals(that.listPassengers) : that.listPassengers != null)
            return false;
        if (listLocomotives != null ? !listLocomotives.equals(that.listLocomotives) : that.listLocomotives != null)
            return false;
        return listWagons != null ? listWagons.equals(that.listWagons) : that.listWagons == null;

    }

    @Override
    public int hashCode() {
        int result = TYPE_TRAIN != null ? TYPE_TRAIN.hashCode() : 0;
        result = 31 * result + (listPassengers != null ? listPassengers.hashCode() : 0);
        result = 31 * result + (listLocomotives != null ? listLocomotives.hashCode() : 0);
        result = 31 * result + (listWagons != null ? listWagons.hashCode() : 0);
        return result;
    }

}
