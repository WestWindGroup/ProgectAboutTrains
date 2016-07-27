package ua.com.westwind.project.controller;

import ua.com.westwind.project.model.trainfactory.PassengerTrain;
import ua.com.westwind.project.view.View;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class InterfaceScreen {

    private int countItemInList;
    private String headScreen;
    private Map<Integer,String> mapListScreenView = new HashMap<>();
    private Map<Integer,String> mapListScreenViewAdditionally = new HashMap<>();
    private TypeInterfaceScreen typeScreen;
    private InterfaceScreen back;
    private InterfaceScreen next;
    private Controller controller;


    public InterfaceScreen(InterfaceScreen back,InterfaceScreen next,String path,TypeInterfaceScreen typeScreen,Controller controller) {
        this.typeScreen = typeScreen;
        readFromFileList(path);
        this.back = back;
        this.next = next;
        this.controller = controller;
    }

    public boolean performSelectedAction(int input){
        if(typeScreen == TypeInterfaceScreen.LIST_TRAIN){
            return performSelectedActionLTrain(input);
        }else if(typeScreen == TypeInterfaceScreen.LIST_CREATE_TRAIN){
            return performSelectedActionLCTrain(input);
        }else if(typeScreen == TypeInterfaceScreen.LIST_ACTION){
            return performSelectedActionLAction(input);
        }else return false;
    }

    private boolean performSelectedActionLTrain(int input){
        if(input == mapListScreenView.size()){
            return true;
        }else{
            PassengerTrain train = null;
            try {
                String route = mapListScreenView.get(input);
                train = controller.createPassengerTrainFromBase(route);
                String help = next.getMapListScreenView().put(next.countItemInList,route);
                next.getMapListScreenView().put(next.countItemInList++,help);
                controller.getMapCreatePassengerTrains().put(route,train);
            } catch (Exception e) {
                controller.showString("Извените, произошла ошибка обработки введённых данных");
            }
            return false;
        }
    }
    private boolean performSelectedActionLCTrain(int input){
        return false;
    }
    private boolean performSelectedActionLAction(int input){
        return false;
    }


    public void showInterfaceScreen(){
        controller.showInterfaceScreen(headScreen,mapListScreenView);
    }


    private void readFromFileList(String path) {
        File file = new File(path);
        countItemInList = 0;
        try (BufferedReader rd = new BufferedReader(new FileReader(file))) {
            String strHelp;
            while ((strHelp = rd.readLine()) != null) {
                if(countItemInList == 0){
                    headScreen = strHelp;
                }else if(strHelp.equals("additionally")){
                    while ((strHelp = rd.readLine()) != null){
                        mapListScreenViewAdditionally.put(countItemInList,strHelp);
                    }
                }else{
                    mapListScreenView.put(countItemInList,strHelp);
                }
                countItemInList++;
            }
        } catch (IOException e) {
            System.out.println("Ошибка чтения файла " + path);
        }
    }

    public String getHeadScreen() {
        return headScreen;
    }

    public void setHeadScreen(String headScreen) {
        this.headScreen = headScreen;
    }

    public Map<Integer, String> getMapListScreenView() {
        return mapListScreenView;
    }

    public void setMapListScreenView(Map<Integer, String> mapListScreenView) {
        this.mapListScreenView = mapListScreenView;
    }

    public Map<Integer, String> getMapListScreenViewAdditionally() {
        return mapListScreenViewAdditionally;
    }

    public void setMapListScreenViewAdditionally(Map<Integer, String> mapListScreenViewAdditionally) {
        this.mapListScreenViewAdditionally = mapListScreenViewAdditionally;
    }


}
