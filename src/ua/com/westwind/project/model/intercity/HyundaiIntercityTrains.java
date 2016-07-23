package ua.com.westwind.project.model.intercity;


import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;

import java.util.ArrayList;

public class HyundaiIntercityTrains extends IntercityTrains {

    public HyundaiIntercityTrains(String route) {
        this.route = route;
        nameTrain = "Hyundai";
        parsingXML();
        countWagonAmount = listInterCityWagon.size();
    }

}
