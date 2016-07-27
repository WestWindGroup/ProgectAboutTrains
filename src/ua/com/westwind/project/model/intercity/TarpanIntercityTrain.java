package ua.com.westwind.project.model.intercity;

public class TarpanIntercityTrain extends IntercityTrain {

    private static final String NAME = "Tarpan";


    public TarpanIntercityTrain() throws Exception {
        super(NAME);
    }

    public TarpanIntercityTrain(String route) throws Exception {
        super(NAME,route);
    }
}
