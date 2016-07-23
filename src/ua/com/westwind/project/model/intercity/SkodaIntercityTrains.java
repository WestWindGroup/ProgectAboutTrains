package ua.com.westwind.project.model.intercity;

public class SkodaIntercityTrains extends IntercityTrains {

    public SkodaIntercityTrains(String route) {
        this.route = route;
        nameTrain = "Skoda";
        parsingXML();
        countWagonAmount = listInterCityWagon.size();
    }
}
