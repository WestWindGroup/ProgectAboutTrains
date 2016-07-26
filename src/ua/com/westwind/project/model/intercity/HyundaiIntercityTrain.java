package ua.com.westwind.project.model.intercity;


public class HyundaiIntercityTrain extends IntercityTrain {

    private static final String NAME = "Hyundai";

    public HyundaiIntercityTrain() {
        super(NAME);
    }

    public HyundaiIntercityTrain(String route) {
        super(NAME,route);
    }

}
