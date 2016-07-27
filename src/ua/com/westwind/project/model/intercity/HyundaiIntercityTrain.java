package ua.com.westwind.project.model.intercity;


public class HyundaiIntercityTrain extends IntercityTrain {

    private static final String NAME = "Hyundai";

    public HyundaiIntercityTrain() throws Exception {
        super(NAME);
    }

    public HyundaiIntercityTrain(String route) throws Exception {
        super(NAME,route);
    }

}
