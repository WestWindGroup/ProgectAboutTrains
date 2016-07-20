package ua.com.westwind.project;


import ua.com.westwind.project.model.intercity.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<IntercityTrains> intercityTrains = new ArrayList<>();
        intercityTrains.add(new SkodaIntercityTrains());
        intercityTrains.add(new TrainLocomotiveTraction());
        intercityTrains.add(new TarpanIntercityTrains());
        intercityTrains.add(new HyundaiIntercityTrains());
        for (IntercityTrains help:intercityTrains) {
            System.out.println(help);
        }

    }
}
