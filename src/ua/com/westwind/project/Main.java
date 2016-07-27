package ua.com.westwind.project;


import ua.com.westwind.project.controller.Controller;
import ua.com.westwind.project.controller.UserScreen;
import ua.com.westwind.project.model.trainfactory.Train;
import ua.com.westwind.project.model.trainfactory.TrainDataProcessing;

public class Main {

    public static void main(String[] args) {

        UserScreen user = new UserScreen();
        user.userInterface();
    }
}
