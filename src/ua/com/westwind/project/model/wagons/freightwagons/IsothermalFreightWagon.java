package ua.com.westwind.project.model.wagons.freightwagons;

public class IsothermalFreightWagon extends FreightWagon {

    private final TypeFreightWagon TYPE_WAGON = TypeFreightWagon.ISOTHERMAL;

    public IsothermalFreightWagon() {
        typeFreightWagon = TYPE_WAGON;
    }

    @Override
    public TypeFreightWagon getTypeFreightWagon() {
        return typeFreightWagon;
    }
}
