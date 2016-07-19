package ua.com.westwind.project.model.wagons.freightwagons;

public enum TypeFreightWagon {
    CISTERN_SV(0),
    COVERRED(1),
    ISOTHERMAL(2),
    PLATFORM(3);

    private int numberType;

    TypeFreightWagon(int numberType){
        this.numberType = numberType;
    }

    public int getNumberType() {
        return numberType;
    }

}