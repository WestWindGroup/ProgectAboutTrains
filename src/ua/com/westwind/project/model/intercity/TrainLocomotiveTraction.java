package ua.com.westwind.project.model.intercity;

public class TrainLocomotiveTraction extends IntercityTrains{

    public TrainLocomotiveTraction(String route) {
        this.route = route;
        nameTrain = "LocomotiveTraction";
        parsingXML();
        countWagonAmount = listInterCityWagon.size();
    }
}
