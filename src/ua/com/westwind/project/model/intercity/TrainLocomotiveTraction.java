package ua.com.westwind.project.model.intercity;

public class TrainLocomotiveTraction extends IntercityTrain {

    private static final String NAME = "LocomotiveTraction";


    public TrainLocomotiveTraction() {
        super(NAME);
    }

    public TrainLocomotiveTraction(String route) {
        super(NAME,route);
    }
}
