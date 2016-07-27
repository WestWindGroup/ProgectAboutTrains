package ua.com.westwind.project.model.intercity;

public class TrainLocomotiveTraction extends IntercityTrain {

    private static final String NAME = "LocomotiveTraction";


    public TrainLocomotiveTraction() throws Exception {
        super(NAME);
    }

    public TrainLocomotiveTraction(String route) throws Exception {
        super(NAME,route);
    }
}
