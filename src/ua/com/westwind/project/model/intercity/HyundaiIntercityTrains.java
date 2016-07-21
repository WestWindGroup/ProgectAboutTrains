package ua.com.westwind.project.model.intercity;


public class HyundaiIntercityTrains extends IntercityTrains {

    public HyundaiIntercityTrains() {
        nameTrain = "Hyundai";
        parsingXML();
        countWagonAmount = listInterCityWagon.size();
    }


}
