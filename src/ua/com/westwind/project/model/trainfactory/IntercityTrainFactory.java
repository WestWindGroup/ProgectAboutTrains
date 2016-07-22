package ua.com.westwind.project.model.trainfactory;

public class IntercityTrainFactory implements TrainFactory{
    private String nameFile;

    public IntercityTrainFactory(String nameFile) {
        this.nameFile = nameFile;
    }

    @Override
    public Train createTrain() {
        return XMLFileParsing.readXMLfileIntercity(nameFile);
    }


}
