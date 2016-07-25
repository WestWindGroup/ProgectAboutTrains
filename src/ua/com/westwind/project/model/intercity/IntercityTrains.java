package ua.com.westwind.project.model.intercity;

import ua.com.westwind.project.model.RollingStock;
import ua.com.westwind.project.model.trainfactory.PassengerTrains;
import ua.com.westwind.project.model.passenger.Passenger;
import ua.com.westwind.project.model.trainfactory.RandomFillPassengerTrain;
import ua.com.westwind.project.model.trainfactory.XMLFileParsing;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

public abstract class IntercityTrains implements RollingStock, PassengerTrains {

    private final String TYPE_TRAIN = "IntercityTrain";
    protected String route;
    protected String nameTrain;
    protected int countWagonAmount;
    protected int countWagonFirstClass;
    protected int countWagonSecondClass;
    protected int countWagonFirstAndSecondClass;
    protected ArrayList<PassengerWagon> listWagons = new ArrayList<>();
    protected ArrayList<Passenger> listPassengers = new ArrayList<>();

    protected void parsingXML() {

        XMLFileParsing.parsingXMLIntercityTrainInfo(nameTrain, listWagons);
        RandomFillPassengerTrain randomFillPassengerTrain = new RandomFillPassengerTrain();
        listPassengers = randomFillPassengerTrain.fillPassengers(route,listWagons);
    }

    @Override
    public String returnTypeTrain() {
        return TYPE_TRAIN;
    }

    public String getNameTrain() {
        return nameTrain;
    }

    public int getCountWagonAmount() {
        return countWagonAmount;
    }

    public int getCountWagonFirstClass() {
        return countWagonFirstClass;
    }

    public int getCountWagonSecondClass() {
        return countWagonSecondClass;
    }

    public int getCountWagonFirstAndSecondClass() {
        return countWagonFirstAndSecondClass;
    }

    @Override
    public String getRoute() {
        return route;
    }

    @Override
    public void setRoute(String route) {
        this.route = route;
    }

    @Override
    public ArrayList<Passenger> getListPassengers() {
        return listPassengers;
    }

    @Override
    public ArrayList<PassengerWagon> getListWagons() {
        return listWagons;
    }

    private void countWagonClass() {
        for (int i = 0; i < listWagons.size(); i++) {
            int h = listWagons.get(i).getPassengerTypeWagon().getComfortLevel();
            switch (h) {
                case 0:
                    countWagonFirstClass++;
                    break;

                case 1:
                    countWagonFirstAndSecondClass++;
                    break;

                case 2:
                    countWagonSecondClass++;
                    break;
            }
        }
    }

    @Override
    public void showTrain() {
        showHeadTrain();
        showWagon();
    }

    @Override
    public void showHeadTrain() {
        printLine();
        System.out.println(nameTrain + " ---- IntrcityTrain ---- " + "route " + "\"" + route + "\"");
        printLine();
    }


    @Override
    public String toString() {
        return TYPE_TRAIN +
                " nameTrain = '" + nameTrain + '\'' +
                ", countWagonAmount = " + countWagonAmount +
                ", countWagonFirstClass = " + countWagonFirstClass +
                ", countWagonSecondClass = " + countWagonSecondClass +
                ", countWagonFirstAndSecondClass = " + countWagonFirstAndSecondClass +
                ", listWagons = " + listWagons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntercityTrains that = (IntercityTrains) o;

        if (countWagonAmount != that.countWagonAmount) return false;
        if (countWagonFirstClass != that.countWagonFirstClass) return false;
        if (countWagonSecondClass != that.countWagonSecondClass) return false;
        if (countWagonFirstAndSecondClass != that.countWagonFirstAndSecondClass) return false;
        if (nameTrain != null ? !nameTrain.equals(that.nameTrain) : that.nameTrain != null) return false;
        return listWagons != null ? listWagons.equals(that.listWagons) : that.listWagons == null;

    }

    @Override
    public int hashCode() {
        int result = nameTrain != null ? nameTrain.hashCode() : 0;
        result = 31 * result + countWagonAmount;
        result = 31 * result + countWagonFirstClass;
        result = 31 * result + countWagonSecondClass;
        result = 31 * result + countWagonFirstAndSecondClass;
        result = 31 * result + (listWagons != null ? listWagons.hashCode() : 0);
        return result;
    }

}
