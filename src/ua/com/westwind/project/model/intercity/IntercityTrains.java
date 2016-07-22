package ua.com.westwind.project.model.intercity;

import ua.com.westwind.project.model.RollingStock;
import ua.com.westwind.project.model.trainfactory.Train;
import ua.com.westwind.project.model.passenger.Passenger;
import ua.com.westwind.project.model.trainfactory.RandomFillPassengerTrain;
import ua.com.westwind.project.model.trainfactory.XMLFileParsing;
import ua.com.westwind.project.model.wagons.passengerwagons.IntercityTypeWagon;
import ua.com.westwind.project.model.wagons.passengerwagons.TypeWagon;

import java.util.ArrayList;

import static ua.com.westwind.project.model.wagons.passengerwagons.IntercityTypeWagon.WAGON_1_AND_2_CLASSES;
import static ua.com.westwind.project.model.wagons.passengerwagons.IntercityTypeWagon.WAGON_1_CLASS;
import static ua.com.westwind.project.model.wagons.passengerwagons.IntercityTypeWagon.WAGON_2_CLASS;

public abstract class IntercityTrains implements RollingStock, Train {
    private final String TYPE_TRAIN = "IntercityTrain";
    protected String nameTrain;
    protected int countWagonAmount;
    protected int countWagonFirstClass;
    protected int countWagonSecondClass;
    protected int countWagonFirstAndSecondClass;
    protected ArrayList<IntercityWagon> listInterCityWagon = new ArrayList<>();
    protected ArrayList<Passenger> listPassengers = new ArrayList<>();

    @Override
    public String returnTypeTrain() {
        return TYPE_TRAIN;
    }

    protected void parsingXML() {

        XMLFileParsing.parsingXMLIntercityTrainInfo(nameTrain, listInterCityWagon);
        RandomFillPassengerTrain randomFillPassengerTrain = new RandomFillPassengerTrain();
        listPassengers = randomFillPassengerTrain.fillPassengers(listInterCityWagon);
    }


    public String getTYPE_TRAIN() {
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

    public void setCountWagonFirstClass(int countWagonFirstClass) {
        this.countWagonFirstClass = countWagonFirstClass;
    }

    public int getCountWagonSecondClass() {
        return countWagonSecondClass;
    }

    public void setCountWagonSecondClass(int countWagonSecondClass) {
        this.countWagonSecondClass = countWagonSecondClass;
    }

    public int getCountWagonFirstAndSecondClass() {
        return countWagonFirstAndSecondClass;
    }

    public void setCountWagonFirstAndSecondClass(int countWagonFirstAndSecondClass) {
        this.countWagonFirstAndSecondClass = countWagonFirstAndSecondClass;
    }

    public ArrayList<IntercityWagon> getListInterCityWagon() {
        return listInterCityWagon;
    }

    public ArrayList<Passenger> getListPassengers() {
        return listPassengers;
    }

    private void countWagonClass() {
        for (int i = 0; i < listInterCityWagon.size(); i++) {
            int h = listInterCityWagon.get(i).getPassengerTypeWagon().getComfortLevel();
            switch (h) {
                case 0:
                    countWagonFirstClass++;
                    break;

                case 1:
                    countWagonSecondClass++;
                    break;

                case 2:
                    countWagonFirstAndSecondClass++;
                    break;
            }
        }
    }


    @Override
    public void showTrain() {

        for (int i = 0; i < listInterCityWagon.size(); i++) {
            System.out.println();
            System.out.println(listInterCityWagon.get(i));
            for (Passenger passenger : listPassengers) {
                if (passenger.getTicket().getNumberWagon() == i + 1) {
                    System.out.println(passenger);
                }
            }
        }
    }

    @Override
    public String toString() {
        return "IntercityTrains{" +
                "nameTrain='" + nameTrain + '\'' +
                ", countWagonAmount=" + countWagonAmount +
                ", countWagonFirstClass=" + countWagonFirstClass +
                ", countWagonSecondClass=" + countWagonSecondClass +
                ", countWagonFirstAndSecondClass=" + countWagonFirstAndSecondClass +
                ", listInterCityWagon=" + listInterCityWagon +
                '}';
    }
}
