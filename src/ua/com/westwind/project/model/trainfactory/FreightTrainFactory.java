package ua.com.westwind.project.model.trainfactory;

public interface FreightTrainFactory {

    FreightTrain createTrain(String route) throws Exception;
}
