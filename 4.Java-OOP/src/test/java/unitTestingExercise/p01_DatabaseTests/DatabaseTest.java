package unitTestingExercise.p01_Database;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

public class DatabaseTest {
    private static final Integer[] NUMBERS = {1, 2, 3, 4};

    private Database database;


    @Before
    public void prep() throws OperationNotSupportedException {
        database = new Database(NUMBERS);
    }


    @Test
    public void databaseShouldCreateDatabase() {
        Integer[] dbElements = database.getElements();

        Assert.assertArrayEquals(dbElements, NUMBERS);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForMoreThan16Elements() throws OperationNotSupportedException {
        Integer[] bigArray = new Integer[17];
        new Database(bigArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionForLessThan1Element() throws OperationNotSupportedException {
        Integer[] smallArray = new Integer[0];
        new Database(smallArray);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseThrowsExceptionForNullElement() throws OperationNotSupportedException {
        database.add(null);
    }

    @Test
    public void databaseShouldAddElementToNextFreeCell() throws OperationNotSupportedException {
        this.database.add(5);
        Integer[] dbAdd = database.getElements();
        Assert.assertEquals(dbAdd.length, NUMBERS.length + 1);
        Assert.assertEquals(dbAdd[dbAdd.length - 1], Integer.valueOf(5));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void databaseShouldThrowExceptionWhenRemovingElementOutOfBounds() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS.length; i++) {
            database.remove();
        }
        database.remove();
    }

    @Test
    public void dataShouldRemoveLastElement() throws OperationNotSupportedException {
        database.remove();
        Integer[] dbElements = database.getElements();
        Assert.assertEquals(NUMBERS.length - 1, dbElements.length);
        Assert.assertEquals(Integer.valueOf(3), dbElements[dbElements.length-1]);
    }


}