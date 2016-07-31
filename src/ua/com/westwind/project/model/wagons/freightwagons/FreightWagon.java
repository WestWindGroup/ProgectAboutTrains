package ua.com.westwind.project.model.wagons.freightwagons;

import ua.com.westwind.project.model.wagons.Wagons;

public abstract class FreightWagon implements Wagons {

    protected TypeFreightWagon typeFreightWagon;

    public TypeFreightWagon getTypeFreightWagon() {
        return typeFreightWagon;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FreightWagon that = (FreightWagon) o;

        return typeFreightWagon == that.typeFreightWagon;

    }

    @Override
    public int hashCode() {
        return typeFreightWagon != null ? typeFreightWagon.hashCode() : 0;
    }
}
