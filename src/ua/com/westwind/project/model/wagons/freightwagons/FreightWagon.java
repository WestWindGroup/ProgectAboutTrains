package ua.com.westwind.project.model.wagons.freightwagons;

import ua.com.westwind.project.model.Wagons;

public abstract class FreightWagon implements Wagons {

    protected TypeFreightWagon typeFreightWagon;

    abstract TypeFreightWagon getTypeFreightWagon();
}
