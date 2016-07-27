package ua.com.westwind.project.model.intercity;

public class SkodaIntercityTrain extends IntercityTrain {

    private static final String NAME = "Skoda";


    public SkodaIntercityTrain() throws Exception {
        super(NAME);
    }

    public SkodaIntercityTrain(String route) throws Exception {
        super(NAME,route);
    }
}
