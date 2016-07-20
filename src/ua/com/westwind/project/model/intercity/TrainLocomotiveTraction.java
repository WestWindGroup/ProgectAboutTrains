package ua.com.westwind.project.model.intercity;

public class TrainLocomotiveTraction extends IntercityTrains{

    public TrainLocomotiveTraction() {
        nameTrain = "LocomotiveTraction";
        parsingXML();
        countWagonAmount = listInterCityWagon.size();
    }
}
