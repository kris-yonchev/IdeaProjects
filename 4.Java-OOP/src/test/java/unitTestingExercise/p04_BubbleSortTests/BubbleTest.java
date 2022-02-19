package unitTestingExercise.p04_BubbleSortTest;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BubbleTest {

    @Test
    public void testSortMethod() {
        int[] arraySortOne = new int[]{13, 2, 4, 74, 1, 100, 25};

        Bubble.sort(arraySortOne);

        int[] expectedArray = new int[]{1, 2, 4, 13, 25, 74, 100};

        Assert.assertArrayEquals(expectedArray, arraySortOne);


    }


}