package ua.com.westwind.project.controller;

import ua.com.westwind.project.model.trainfactory.PassengerTrains;
import ua.com.westwind.project.model.trainfactory.TrainDataProcessing;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;
import ua.com.westwind.project.view.View;

import java.io.*;
import java.util.*;

public class Controller extends View {

    private int numCreateTrainInList;
    private Map<Integer,String> mapListTrains = new HashMap<>();
    private Map<Integer,String> mapListCreateTrains = new HashMap<>();
    private Map<Integer,String> mapListActionsOnTrain = new HashMap<>();
    private Map<String, PassengerTrains> mapCreatePassengerTrains = new HashMap<>();
    private TrainDataProcessing trainDataProcessing = new TrainDataProcessing();


    private PassengerTrains createPassengerTrainFromBase(String route) {

        PassengerTrains train = trainDataProcessing.routePassengerTrainInObjectTrain(route);
        if (mapCreatePassengerTrains.put(route, train) == null) {
            numCreateTrainInList++;
            mapListCreateTrains.put(numCreateTrainInList,route);
        }

        return train;
    }

    private void showPassengerTrain(PassengerTrains train) {
        showTrainInConsole(train);
    }

    private  void getInPassengerTrainCountPassenger(PassengerTrains train) {
        int countPassenger = trainDataProcessing.countBusyPlacesInTrain(train);
        String str = "В поезде " + train.getRoute() + " " + countPassenger + " пассажиров";
        showString(str);
    }

    private  void getInPassengerTrainAllMassBaggege(PassengerTrains train) {
        double allMassBaggege = trainDataProcessing.countAllMassBaggegeInTrain(train);
        String format = String.format(" %.2f", allMassBaggege);
        String str = "В поезде " + train.getRoute() + " общее колличество баггажа" + format + " kg";
        showString(str);
    }

    private void sortPassengerTrainOfComfort(PassengerTrains train) {
        ArrayList<PassengerWagon> listPW = (ArrayList<PassengerWagon>) train.getListPassengerWagon().clone();
        Collections.sort(listPW);
        showPassengerWagonList(listPW);
    }

    private void searchWagonByCountPassengers(PassengerTrains train,
                                             int minCountPassengers,
                                             int maxCountPassengers) {
        ArrayList<PassengerWagon> listPW =
                trainDataProcessing.searchWagonByCountPassengers(train, minCountPassengers, maxCountPassengers);
        if (listPW != null) {
            showPassengerWagonList(listPW);
        } else {
            showString("Вагоны с колличеством пассажиров от " +
                    minCountPassengers + " до " + maxCountPassengers +
                    " отсутствуют\n");
        }

    }

    public void proogrammON(){
        UserInterface user = new UserInterface();
        user.userInterface();
    }

    private class UserInterface {

        private int numInListTrain;
        private int numInListActions;

        private String pathToFileRoutesPassengerTrains = "Route.txt";
        private String pathToFileListActionsOnTrain = "Actions.txt";
        private String itemReturnMenuUp = "Назад";
        private String itemEndProgram = "Выход из программы";
        private String itemListCreateTrains = "Список созданых поездов";
        private String messageErrorChoice = "\nТакого пункта нет в списке.\nВыбирите пожалуйста номер пункта из списка\n";
        private String messageInputValue =  "Введите минимальное и максимальное колличество пассажиров в вагоне\n" +
                "Вводимое число должно быть больше нуля и меньше 135" ;
        private String messageErrorInputData = "Вводимое число должно быть больше нуля и меньше 135";
        private String createTrain = "\nСОЗДАТЬ ПОЕЗД (например Lviv-Kremenchuk нажмите 1 , Lviv-Dnepr нажмите 3 и т.д)";
        private String line = "--------------------------------------------------------------------------------";

        public void userInterface() {
            int countHelp = 0;
            boolean endWork = false;
            numInListTrain = readFromFileList(pathToFileRoutesPassengerTrains,
                    mapListTrains,
                    numInListTrain,
                    itemEndProgram);
            numInListActions = readFromFileList(pathToFileListActionsOnTrain,
                    mapListActionsOnTrain,
                    numInListActions,
                    itemReturnMenuUp);
            try (Scanner sc = new Scanner(System.in)) {
                while (!endWork) {
                    if(countHelp == 0){
                        showString(createTrain);
                        showString(line);
                        showMapList(mapListTrains);
                        showString(line);
                        showString(line);
                    }
                    if (sc.hasNextInt()) {
                        int numberTrainInList = sc.nextInt();
                        if ((numberTrainInList > 0) && (numberTrainInList <= numInListTrain)) {
                            PassengerTrains train = createPassengerTrainFromBase(mapListTrains.get(numberTrainInList));
                            mapListTrains.put(numInListTrain + 2,itemListCreateTrains);
                            if (train != null) {
                                showString("Поезд создан");
                                showHeadTrainInConsole(train);
                            }
                        } else if (numberTrainInList == numInListTrain + 1) {
                            endWork = true;
                        } else if ((mapListCreateTrains.size() != 0) && (numberTrainInList == numInListTrain + 2)) {
                            mapListCreateTrains.put(numCreateTrainInList + 1, itemReturnMenuUp);
                            workWithListCreateTrains(sc);
                        } else {
                            showString(messageErrorChoice);
                        }
                    } else {
                        countHelp++;
                        sc.nextLine();
                        if(countHelp == 1) {
                            showString(messageErrorChoice);
                        }
                        else{
                            countHelp = 0;
                        }
                    }
                }
            }
        }

        private void workWithListCreateTrains(Scanner sc) {
            int countHelp = 0;
            boolean endWork = false;
            while (!endWork) {
                if(countHelp == 0) {
                    showString(line);
                    showString("СПИСОК СОЗДАНЫХ ПОЕЗДОВ");
                    showString(line);
                    showMapList(mapListCreateTrains);
                    showString(line);
                }
                if (sc.hasNextInt()) {
                    int numberTrainInList = sc.nextInt();
                    if ((numberTrainInList > 0) && (numberTrainInList <= numCreateTrainInList)) {
                        String help = mapListCreateTrains.get(numberTrainInList);
                        PassengerTrains train = mapCreatePassengerTrains.get(help);
                        workWithTrain(sc,train);
                    } else if (numberTrainInList == numCreateTrainInList + 1) {
                        mapListCreateTrains.remove(numCreateTrainInList + 1);
                        endWork = true;
                    } else {
                        showString(messageErrorChoice);
                    }
                }else {
                    countHelp++;
                    sc.nextLine();
                    if(countHelp == 1) {
                        showString(messageErrorChoice);
                    }
                    else{
                        countHelp = 0;
                    }
                }

            }

        }

        private void workWithTrain(Scanner sc,PassengerTrains train) {
            int countHelp = 0;
            boolean endWork = false;
            while (!endWork) {
                if(countHelp == 0) {
                    showHeadTrainInConsole(train);
                    showString("ВОЗМОЖНЫЕ ОПЕРАЦИИ");
                    showString(line);
                    showMapList(mapListActionsOnTrain);
                    showString(line);
                }
                if (sc.hasNextInt()) {
                    int numberTrainInList = sc.nextInt();
                    if ((numberTrainInList > 0) && (numberTrainInList <= numInListActions)) {
                        switch (numberTrainInList){
                            case 1:
                                getInPassengerTrainCountPassenger(train);
                                getInPassengerTrainAllMassBaggege(train);
                                break;

                            case 2:
                                sortPassengerTrainOfComfort(train);
                                break;

                            case 3:
                                showString(line);
                                showString(messageInputValue);
                                showString(line);
                                int one = inputMinAndMax(sc);
                                int two = inputMinAndMax(sc);
                                if(one <= two){
                                    searchWagonByCountPassengers(train,one,two);
                                }else{
                                    searchWagonByCountPassengers(train,two,one);
                                }
                                break;

                            case 4:
                                showPassengerTrain(train);
                                break;
                        }
                    } else if (numberTrainInList == numInListActions + 1) {
                        endWork = true;
                    } else {
                        showString(messageErrorChoice);
                    }
                }else {
                    countHelp++;
                    sc.nextLine();
                    if(countHelp == 1) {
                        showString(messageErrorChoice);
                    }
                    else{
                        countHelp = 0;
                    }
                }
            }
        }

        private int inputMinAndMax(Scanner sc) {
            int countHelp = 0;
            int minCountPassengerInWagon = 0;
            int maxCountPassengerInWagon = 135;
            boolean endWork = false;
            int number = 0;
            int help = 0;
            while (!endWork) {
                if (sc.hasNextInt() &&
                        ((help = sc.nextInt()) >= minCountPassengerInWagon) &&
                        (help <= maxCountPassengerInWagon)) {
                    number = help;
                    endWork = true;
                }else {
                    countHelp++;
                    sc.nextLine();
                    if(countHelp == 1) {
                        showString(messageErrorInputData);
                    }
                    else{
                        countHelp = 0;
                    }
                }
            }
            return number;
        }

        private int readFromFileList(String path,Map<Integer,String> map,int num,String str) {
            File file = new File(path);
            try (BufferedReader rd = new BufferedReader(new FileReader(file))) {
                String s;
                while ((s = rd.readLine()) != null) {
                    num++;
                    map.put(num,s);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            map.put(num + 1,str);
            return num;
        }
    }
}
