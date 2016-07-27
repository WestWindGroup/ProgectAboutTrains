package ua.com.westwind.project.model.trainfactory;

public class IntercityPassengerTrainFactory implements PassengerTrainFactory {
    private String nameFile;

    public IntercityPassengerTrainFactory(String nameFile) {
        this.nameFile = nameFile;
    }

    @Override
    public PassengerTrain createTrain(String route) throws Exception {
        return XMLFileParsing.readXMLfileIntercity(route,nameFile);
    }


}
