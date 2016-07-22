package ua.com.westwind.project.model.lokomotives;

public class GasTurbinesLocomotive implements Locomotives {
    private final String NAME_LOCOMOTIVE = "GasTurbinesLocomotive";

    @Override
    public String toString() {
        return NAME_LOCOMOTIVE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GasTurbinesLocomotive that = (GasTurbinesLocomotive) o;

        return NAME_LOCOMOTIVE != null ? NAME_LOCOMOTIVE.equals(that.NAME_LOCOMOTIVE) : that.NAME_LOCOMOTIVE == null;

    }

    @Override
    public int hashCode() {
        return NAME_LOCOMOTIVE != null ? NAME_LOCOMOTIVE.hashCode() : 0;
    }
}
