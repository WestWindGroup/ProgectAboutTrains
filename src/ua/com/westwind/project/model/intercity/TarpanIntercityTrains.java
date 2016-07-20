package ua.com.westwind.project.model.intercity;

public class TarpanIntercityTrains extends IntercityTrains {

    public TarpanIntercityTrains() {
        nameTrain = "Tarpan";
        parsingXML();
        countWagonAmount = listInterCityWagon.size();
    }
}
