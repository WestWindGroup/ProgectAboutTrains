package ua.com.westwind.project.model.wagons.freightwagons;

public class CoverredFreightWagon extends FreightWagon {

    private final TypeFreightWagon TYPE_WAGON = TypeFreightWagon.COVERRED;

    public CoverredFreightWagon() {
        typeFreightWagon = TYPE_WAGON;
    }

    @Override
    public TypeFreightWagon getTypeFreightWagon() {
        return TYPE_WAGON;
    }
}
