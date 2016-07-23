package ua.com.westwind.project.model.trainfactory;

public class IntercityPassengerTrainFactory implements PassengerTrainFactory {
    private String nameFile;

    public IntercityPassengerTrainFactory(String nameFile) {
        this.nameFile = nameFile;
    }

    @Override
    public PassengerTrains createTrain(String route) {
        return XMLFileParsing.readXMLfileIntercity(route,nameFile);
    }


}
