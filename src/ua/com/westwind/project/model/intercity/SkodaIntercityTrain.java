package ua.com.westwind.project.model.intercity;

public class SkodaIntercityTrain extends IntercityTrain {

    private static final String NAME = "Skoda";


    public SkodaIntercityTrain() {
        super(NAME);
    }

    public SkodaIntercityTrain(String route) {
        super(NAME,route);
    }
}
