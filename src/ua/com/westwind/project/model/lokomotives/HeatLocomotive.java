package ua.com.westwind.project.model.lokomotives;

import ua.com.westwind.project.model.Locomotives;

public class HeatLocomotive implements Locomotives {

    private final String NAME_LOCOMOTIVE = "HeatLocomotive";

    @Override
    public String toString() {
        return NAME_LOCOMOTIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        HeatLocomotive that = (HeatLocomotive) o;

        return NAME_LOCOMOTIVE != null ? NAME_LOCOMOTIVE.equals(that.NAME_LOCOMOTIVE) : that.NAME_LOCOMOTIVE == null;

    }

    @Override
    public int hashCode() {
        return NAME_LOCOMOTIVE != null ? NAME_LOCOMOTIVE.hashCode() : 0;
    }
}

