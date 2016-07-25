package ua.com.westwind.project.model.intercity;


public class HyundaiIntercityTrains extends IntercityTrains {

    public HyundaiIntercityTrains(String route) {
        this.route = route;
        nameTrain = "Hyundai";
        parsingXML();
        countWagonAmount = listWagons.size();
    }

}
