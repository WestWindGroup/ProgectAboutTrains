package ua.com.westwind.project.model.wagons.place;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class PlaceTest {

    Place place;
    int numPlace;
    TypePlace typePlace;

    @Before
    public void setUp() throws Exception {
        numPlace = 55;
        typePlace = TypePassengerPlace.DOWN_PLACE;
        place = new Place(numPlace,typePlace);
        place.setBusy(true);
    }

    @Test
    public void getTypePlace() throws Exception {
        Assert.assertTrue(typePlace.equals(place.getTypePlace()));
    }

    @Test
    public void setTypePlace() throws Exception {
        place.setTypePlace(TypePassengerPlace.SEAT_PLACE);
        Assert.assertFalse(typePlace.equals(place.getTypePlace()));
    }

    @Test
    public void getNumberPlace() throws Exception {
        Assert.assertTrue(numPlace == place.getNumberPlace());
    }

    @Test
    public void setNumberPlace() throws Exception {
        place.setNumberPlace(44);
        Assert.assertFalse(numPlace == place.getNumberPlace());
    }

    @Test
    public void isBusy() throws Exception {
        Assert.assertTrue(place.isBusy());
    }

    @Test
    public void setBusy() throws Exception {
        place.setBusy(false);
        Assert.assertFalse(place.isBusy());
    }

    @Test
    public void testToString() throws Exception {
        Assert.assertNotNull(place.toString());
        Assert.assertTrue(place.toString().getClass()==String.class);
    }

    @Test
    public void equals() throws Exception {
        int numPlace1 = 55;
        TypePlace typePlace1 = TypePassengerPlace.DOWN_PLACE;
        Place place1 = new Place(numPlace1,typePlace1);
        place1.setBusy(true);
        Assert.assertTrue(place.equals(place1));
        place1.setNumberPlace(33);
        Assert.assertFalse(place.equals(place1));
    }

    @Test
    public void testHashCode() throws Exception {
        int numPlace1 = 55;
        TypePlace typePlace1 = TypePassengerPlace.DOWN_PLACE;
        Place place1 = new Place(numPlace1,typePlace1);
        place1.setBusy(true);
        Assert.assertTrue(place.hashCode() == place1.hashCode());
        place1.setNumberPlace(33);
        Assert.assertFalse(place.hashCode() == place1.hashCode());
    }

}