package ua.com.westwind.project.controller;

import ua.com.westwind.project.model.trainfactory.PassengerTrains;
import ua.com.westwind.project.model.trainfactory.TrainDataProcessing;
import ua.com.westwind.project.model.wagons.passengerwagons.PassengerWagon;
import ua.com.westwind.project.view.View;

import java.io.*;
import java.util.*;

public class Controller extends View {
    private int numEndProgram;
    private int numReturnMenuUp;
    private int numItemListCreateTrains;
    private int numInListTrain;
    private int numCreateTrainInList;

    private String pathToFilePassengerRoutesTrains = "Route.txt";
    private Map<String, PassengerTrains> mapPassengerTrains = new HashMap<>();
    private TrainDataProcessing trainDataProcessing = new TrainDataProcessing();

    private Map<Integer,String> listTrain = new HashMap<>();
    private Map<Integer,String> listCreateTrains = new HashMap<>();
    private String listTrainString = "";
    private String createTrain = "\nСОЗДАТЬ ПОЕЗД (например Lviv-Kremenchuk нажмите 1 , Lviv-Dnepr нажмите 3 и т.д)";
    private String line = "--------------------------------------------------------------------------------";
    private String endProgram = "Выход из программы";
    private String returnMenuUp;
    private String itemListCreateTrains = "Список созданых поездов";
    private String listCreateTrainsString = "";

    private String errorChoice = "\nТакого пункта нет в списке.\nВыбирите пожалуйста номер пункта из списка\n";

    private PassengerTrains createPassengerTrainFromBase(String route) {

        PassengerTrains train = trainDataProcessing.routePassengerTrainInObjectTrain(route);
        if (mapPassengerTrains.put(route, train) == null) {
            numCreateTrainInList++;
            listCreateTrainsString = listCreateTrainsString + numCreateTrainInList + ". " + route + "\n";
            listCreateTrains.put(numCreateTrainInList,route);
        }

        return train;
    }

    public void showPassengerTrain(String route) {
        showTrainInConsole(mapPassengerTrains.get(route));
    }

    public void getInPassengerTrainCountPassenger(String route) {
        int countPassenger = trainDataProcessing.countBusyPlacesInTrain(mapPassengerTrains.get(route));
        String str = "In train " + route + " " + countPassenger + " passengers";
        showString(str);
    }

    public void getInPassengerTrainAllMassBaggege(String route) {
        double allMassBaggege = trainDataProcessing.countAllMassBaggegeInTrain(mapPassengerTrains.get(route));
        String format = String.format(" %.2f", allMassBaggege);
        String str = "In train " + route + " all mass a baggage" + format + " kg";
        showString(str);
    }

    public void sortPassengerTrainOfComfort(String route) {
        PassengerTrains train = mapPassengerTrains.get(route);
        ArrayList<PassengerWagon> listPW = (ArrayList<PassengerWagon>) train.getListPassengerWagon().clone();
        Collections.sort(listPW);
        showPassengerWagonList(listPW);
    }

    public void searchWagonByCountPassengers(String route,
                                             int minCountPassengers,
                                             int maxCountPassengers) {
        PassengerTrains train = mapPassengerTrains.get(route);
        ArrayList<PassengerWagon> listPW =
                trainDataProcessing.searchWagonByCountPassengers(train, minCountPassengers, maxCountPassengers);
        if (listPW != null) {
            showPassengerWagonList(listPW);
        } else {
            showString("No wagonss satisfying these conditions");
        }

    }

    public void userInterface() {
        boolean endWork = false;
        readFromFile();
        try (Scanner sc = new Scanner(System.in)) {
            while (!endWork) {
                showString(createTrain);
                showString(line);
                showString(listTrainString);
                showString(line);
                showString(endProgram);
                if (mapPassengerTrains.size() != 0) {
                    showString(itemListCreateTrains);
                }
                showString(line);
                int numberTrainInList = 0;
                if (sc.hasNextInt()) {
                    numberTrainInList = sc.nextInt();
                    if ((numberTrainInList > 0) && (numberTrainInList <= numInListTrain)) {
                        PassengerTrains train = createPassengerTrainFromBase(listTrain.get(numberTrainInList));
                        if (train != null) {
                            showString("Поезд создан");
                            showHeadTrainInConsole(train);
                        }
                    } else if (numberTrainInList == numEndProgram) {
                        endWork = true;
                    } else if ((mapPassengerTrains.size() != 0) && (numberTrainInList == numItemListCreateTrains)) {
                        numReturnMenuUp = listCreateTrains.size() + 1;
                        returnMenuUp = "" + numReturnMenuUp +". Назад";
                        workWithListCreateTrains(sc);
                    } else {
                        showString(errorChoice);
                    }
                } else {
                    sc.nextLine();
                    showString(errorChoice);
                }

            }
        }
    }

    private void workWithListCreateTrains(Scanner sc) {
        boolean endWork = false;
        while (!endWork) {
            showString(line);
            showString("СПИСОК СОЗДАНЫХ ПОЕЗДОВ");
            showString(line);
            showString(listCreateTrainsString);
            showString(line);
            showString(returnMenuUp);
            if (sc.hasNextInt()) {
                int numberTrainInList = sc.nextInt();
                if ((numberTrainInList > 0) && (numberTrainInList <= numCreateTrainInList)) {
                    String help = listCreateTrains.get(numberTrainInList);
                    PassengerTrains train = mapPassengerTrains.get(help);
                    showHeadTrainInConsole(train);
                    workWithTrain(sc);
                } else if (numberTrainInList == numReturnMenuUp) {
                    endWork = true;
                } else {
                    showString(errorChoice);
                }
            }else {
                sc.nextLine();
                showString(errorChoice);
            }

        }

    }

    private void workWithTrain(Scanner sc) {
        boolean endWork = false;
        while (!endWork) {
            showString("ВОЗМОЖНЫЕ ОПЕРАЦИИ");
            showString(line);
            showString(listCreateTrainsString);
            showString(line);
            showString(returnMenuUp);
            if (sc.hasNextInt()) {
                int numberTrainInList = sc.nextInt();
                if ((numberTrainInList > 0) && (numberTrainInList <= numCreateTrainInList)) {
                    String help = listCreateTrains.get(numberTrainInList);
                    PassengerTrains train = mapPassengerTrains.get(help);
                    showHeadTrainInConsole(train);
                } else if (numberTrainInList == numReturnMenuUp) {
                    endWork = true;
                } else {
                    showString(errorChoice);
                }
            }else {
                sc.nextLine();
                showString(errorChoice);
            }

        }

    }

    public Map<Integer,String> readFromFile() {
        File file = new File(pathToFilePassengerRoutesTrains);
        Map<Integer,String> textRead = new HashMap<>();
        try (BufferedReader rd = new BufferedReader(new FileReader(file))) {
            String s;
            while ((s = rd.readLine()) != null) {
                numInListTrain++;
                listTrain.put(numInListTrain,s);
                listTrainString = listTrainString + numInListTrain + ". " + s + "\n";
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        numEndProgram = numInListTrain + 1;
        numItemListCreateTrains = numInListTrain + 2;
        endProgram = "" + numEndProgram +". " + endProgram;
        itemListCreateTrains = "" + numItemListCreateTrains +". " + itemListCreateTrains;
        return textRead;
    }

    private String returnRoute(int number) {
        return listTrain.get(number);
    }

//    private String returnRoute(int number) {
//        if (number == 1) {
//            return "Lviv-Kremenchuk";
//        } else if (number == 2) {
//            return "Lviv-Kiev";
//        } else if (number == 3) {
//            return "Lviv-Dnepr";
//        } else if (number == 4) {
//            return "Poltava-Kharkov";
//        } else if (number == 5) {
//            return "Kharkov-Odessa";
//        } else return null;
//    }
}
