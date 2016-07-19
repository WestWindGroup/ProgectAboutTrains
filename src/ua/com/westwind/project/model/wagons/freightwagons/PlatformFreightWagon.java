package ua.com.westwind.project.model.wagons.freightwagons;

public class PlatformFreightWagon extends FreightWagon {

    private final TypeFreightWagon TYPE_WAGON = TypeFreightWagon.PLATFORM;

    public PlatformFreightWagon() {
        typeFreightWagon = TYPE_WAGON;
    }

    @Override
    public TypeFreightWagon getTypeFreightWagon() {
        return TYPE_WAGON;
    }
}
