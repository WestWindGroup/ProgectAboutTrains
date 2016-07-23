package ua.com.westwind.project.model.intercity;

public class TarpanIntercityTrains extends IntercityTrains {

    public TarpanIntercityTrains(String route) {
        this.route = route;
        nameTrain = "Tarpan";
        parsingXML();
        countWagonAmount = listInterCityWagon.size();
    }
}
