package ua.com.westwind.project.model.trainfactory;

public interface Train{

    String getRoute();

    void setRoute(String route);

    String returnTypeTrain();

    void showTrain();

    void showHeadTrain();

    default void printLine(){
        System.out.println(
                "---------------------------------------------------------------------------------------------------");
    }

}
