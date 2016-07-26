package ua.com.westwind.project.model.intercity;

public class TarpanIntercityTrain extends IntercityTrain {

    private static final String NAME = "Tarpan";


    public TarpanIntercityTrain() {
        super(NAME);
    }

    public TarpanIntercityTrain(String route) {
        super(NAME,route);
    }
}
