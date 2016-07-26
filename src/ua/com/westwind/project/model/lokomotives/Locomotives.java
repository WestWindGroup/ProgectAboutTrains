package ua.com.westwind.project.model.lokomotives;

import ua.com.westwind.project.model.RollingStock;

public abstract class Locomotives implements RollingStock {

    protected String nameLocomotive;


    public String getNameLocomotive() {
        return nameLocomotive;
    }

    @Override
    public String toString() {
        return nameLocomotive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ElectricLocomotive that = (ElectricLocomotive) o;

        return nameLocomotive != null ? nameLocomotive.equals(that.nameLocomotive) : that.nameLocomotive == null;

    }

    @Override
    public int hashCode() {
        return nameLocomotive != null ? nameLocomotive.hashCode() : 0;
    }
}
