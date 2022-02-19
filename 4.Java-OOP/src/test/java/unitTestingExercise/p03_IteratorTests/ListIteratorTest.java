package unitTestingExercise.p03_IteratorTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.jupiter.api.Assertions.*;

public class ListIteratorTest {

    private ListIterator listIterator;
    private static final String[] NAMES = new String[]{"Pesho", "Misho", "Gasho"};


    @Before
    public void prep() throws OperationNotSupportedException {
        listIterator = new ListIterator(NAMES);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorShouldThrowException() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNext() {
        while (listIterator.hasNext()) {
            listIterator.move();
        }
        Assert.assertFalse(listIterator.hasNext());

    }

    @Test
    public void testMove() {
        listIterator.move();
        listIterator.move();
        Assert.assertFalse(listIterator.move());
    }

    @Test(expected = IllegalStateException.class)
    public void listShouldPrintExceptionForEmptyList() throws OperationNotSupportedException {
        listIterator = new ListIterator();
        listIterator.print();
    }

    @Test
    public void listTestPrint() {
        int index = 0;
        while (listIterator.hasNext()) {
            Assert.assertEquals(NAMES[0], listIterator.print());
            index++;
            listIterator.move();
        }
    }

}