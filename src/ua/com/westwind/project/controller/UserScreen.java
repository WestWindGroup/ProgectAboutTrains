package ua.com.westwind.project.controller;

import ua.com.westwind.project.model.trainfactory.PassengerTrain;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;

public class UserScreen {

    private String pathToFileRoutesPassengerTrains = "resources\\passenger\\Route.txt";
    private String pathToFileCreateTrainsOnTrain = "resources\\passenger\\CreateTrains.txt";
    private String pathToFileListActionsOnTrain = "resources\\passenger\\Actions.txt";
    private String messageErrorChoice = "\nТакого пункта нет в списке.\nВыбирите пожалуйста номер пункта из списка\n";
    private String messageInputValue = "Введите минимальное и максимальное колличество пассажиров в вагоне\n" +
            "Вводимое число должно быть больше нуля и меньше 135" ;
    private String messageErrorInputData = "Вводимое число должно быть больше нуля и меньше 135";
    private InterfaceScreen listTrain;
    private InterfaceScreen listCreateTrain;
    private InterfaceScreen listAction;
    Controller controller;

    public UserScreen() {
        controller = new Controller();
        listTrain = new InterfaceScreen(null,listCreateTrain,pathToFileRoutesPassengerTrains,TypeInterfaceScreen.LIST_TRAIN,controller);
        listCreateTrain = new InterfaceScreen(listTrain,listAction,pathToFileCreateTrainsOnTrain,TypeInterfaceScreen.LIST_CREATE_TRAIN,controller);
        listAction = new InterfaceScreen(listCreateTrain,null,pathToFileListActionsOnTrain,TypeInterfaceScreen.LIST_ACTION,controller);
    }


    public void userInterface() {
        try (Scanner sc = new Scanner(System.in)) {
            createTrains(sc,listTrain);
        }
    }

    private void createTrains(Scanner sc,InterfaceScreen interfaceScreen){
        int countHelp = 0;
        boolean endWork = false;
        while (!endWork) {
            if(countHelp == 0){
                interfaceScreen.showInterfaceScreen();
            }
            if (sc.hasNextInt()) {
                int inputNumber = sc.nextInt();
                if ((inputNumber > 0) && (inputNumber <= interfaceScreen.getMapListScreenView().size())) {
                    endWork = listTrain.performSelectedAction(inputNumber);

                } else {
                    controller.showString(messageErrorChoice);
                }
            } else {
                countHelp++;
                sc.nextLine();
                if(countHelp == 1) {
                    controller.showString(messageErrorChoice);
                }
                else{
                    countHelp = 0;
                }
            }
        }
    }


//    private int readFromFileList(String path, Map<Integer,String> map, int num, String str) {
//        File file = new File(path);
//        try (BufferedReader rd = new BufferedReader(new FileReader(file))) {
//            String s;
//            while ((s = rd.readLine()) != null) {
//                num++;
//                map.put(num,s);
//            }
//
//        } catch (IOException e) {
//            System.out.println("Ошибка чтения файла " + path);
//        }
//        map.put(num + 1,str);
//        return num;
//    }
}