package ua.com.westwind.project.model.wagons.freightwagons;

public class CisternFreightWagon extends FreightWagon {

    private final TypeFreightWagon TYPE_WAGON = TypeFreightWagon.CISTERN;

    public CisternFreightWagon() {
        typeFreightWagon = TYPE_WAGON;
    }

    @Override
    public TypeFreightWagon getTypeFreightWagon() {
        return typeFreightWagon;
    }
}
