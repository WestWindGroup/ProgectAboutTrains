package ua.com.westwind.project.model.intercity;

import ua.com.westwind.project.model.RollingStock;
import ua.com.westwind.project.model.trainfactory.PassengerTrain;
import ua.com.westwind.project.model.passenger.Passenger;
import ua.com.westwind.project.model.trainfactory.RandomFillPassengersTrain;
import ua.com.westwind.project.model.trainfactory.XMLFileParsing;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

public abstract class IntercityTrain implements RollingStock, PassengerTrain {

    protected String typeTrain = "IntercityTrain";
    protected String route;
    protected String nameTrain;
    protected int countWagonsAmount;
    protected int countWagonsFirstClass;
    protected int countWagonsSecondClass;
    protected int countWagonsFirstAndSecondClass;
    protected ArrayList<PassengerWagon> listWagons = new ArrayList<>();
    protected ArrayList<Passenger> listPassengers = new ArrayList<>();

    protected IntercityTrain(String nameTrain){
        this.nameTrain = nameTrain;
        typeTrain = typeTrain + " " + nameTrain;
        parsingXML();
        countWagonsAmount = listWagons.size();
        countWagonClass();
    }

    protected IntercityTrain(String nameTrain,String route){
        this(nameTrain);
        this.route = route;
        randomFill();
    }

    private void parsingXML() {
        XMLFileParsing.parsingXMLIntercityTrainInfo(nameTrain, listWagons);
    }

    private void randomFill(){
        RandomFillPassengersTrain randomFillPassengersTrain = new RandomFillPassengersTrain();
        listPassengers = randomFillPassengersTrain.fillPassengers(route,listWagons);
    }

    @Override
    public String getTypeTrain() {
        return typeTrain;
    }


    public String getNameTrain() {
        return nameTrain;
    }

    public int getCountWagonsAmount() {
        return countWagonsAmount;
    }

    public int getCountWagonsFirstClass() {
        return countWagonsFirstClass;
    }

    public int getCountWagonsSecondClass() {
        return countWagonsSecondClass;
    }

    public int getCountWagonsFirstAndSecondClass() {
        return countWagonsFirstAndSecondClass;
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
            int comfort = listWagons.get(i).getPassengerTypeWagon().getComfortLevel();
            switch (comfort) {
                case 0:
                    countWagonsFirstClass++;
                    break;

                case 1:
                    countWagonsFirstAndSecondClass++;
                    break;

                case 2:
                    countWagonsSecondClass++;
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
    public String toString() {
        return typeTrain +
                " nameTrain = '" + nameTrain + '\'' +
                ", countWagonsAmount = " + countWagonsAmount +
                ", countWagonsFirstClass = " + countWagonsFirstClass +
                ", countWagonsSecondClass = " + countWagonsSecondClass +
                ", countWagonsFirstAndSecondClass = " + countWagonsFirstAndSecondClass +
                ", listWagons = " + listWagons;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        IntercityTrain that = (IntercityTrain) o;

        if (countWagonsAmount != that.countWagonsAmount) return false;
        if (countWagonsFirstClass != that.countWagonsFirstClass) return false;
        if (countWagonsSecondClass != that.countWagonsSecondClass) return false;
        if (countWagonsFirstAndSecondClass != that.countWagonsFirstAndSecondClass) return false;
        if (nameTrain != null ? !nameTrain.equals(that.nameTrain) : that.nameTrain != null) return false;
        return listWagons != null ? listWagons.equals(that.listWagons) : that.listWagons == null;

    }

    @Override
    public int hashCode() {
        int result = nameTrain != null ? nameTrain.hashCode() : 0;
        result = 31 * result + countWagonsAmount;
        result = 31 * result + countWagonsFirstClass;
        result = 31 * result + countWagonsSecondClass;
        result = 31 * result + countWagonsFirstAndSecondClass;
        result = 31 * result + (listWagons != null ? listWagons.hashCode() : 0);
        return result;
    }

}
