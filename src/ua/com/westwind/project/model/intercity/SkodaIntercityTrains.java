package ua.com.westwind.project.model.intercity;

public class SkodaIntercityTrains extends IntercityTrains {

    public SkodaIntercityTrains() {
        nameTrain = "Skoda";
        parsingXML();
        countWagonAmount = listInterCityWagon.size();
    }
}
