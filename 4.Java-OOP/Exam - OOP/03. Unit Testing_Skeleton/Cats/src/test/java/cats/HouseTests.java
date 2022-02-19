package cats;

import org.junit.Assert;
import org.junit.Test;

public class HouseTests {

    private House house;


    @Test(expected = NullPointerException.class)
    public void testForHouseNameNull() {
        house = new House(null, 5);
    }

    @Test
    public void testShouldSetNameCorrect() {
        house = new House("House", 5);
        Assert.assertEquals("House", house.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForCapacityBelow0() {
        house = new House("House", -1);
    }

    @Test
    public void testCapacityGetter() {
        house = new House("House", 5);
        Assert.assertEquals(5, house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHouseIsFull() {
        house = new House("House", 1);
        house.addCat(new Cat("Pesho"));
        house.addCat(new Cat("Gasho"));
    }

    @Test
    public void testGetCount() {
        house = new House("House", 2);
        Assert.assertEquals(0, house.getCount());
        house.addCat(new Cat("Pesho"));
        Assert.assertEquals(1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForNonExistingCat() {
        house = new House("House", 2);
        house.removeCat("Agashnik");
    }

    @Test
    public void testRemoveCat() {
        house = new House("House", 2);
        Cat cat = new Cat("Fosho");
        house.addCat(cat);
        Assert.assertEquals(1, house.getCount());
        house.removeCat("Fosho");
        Assert.assertEquals(0, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullCatForSale() {
        house = new House("House", 2);
        house.catForSale("Misho");
    }

    @Test
    public void testSellCatMethod() {
        house = new House("House", 2);
        Cat cat = new Cat("Misho");
        house.addCat(cat);
        house.catForSale("Misho");
        Assert.assertFalse(cat.isHungry());
        Assert.assertEquals(cat, house.catForSale("Misho"));
    }

    @Test
    public void testStatistics() {
        house = new House("House", 2);
        Cat cat = new Cat("Misho");
        Cat cat2 = new Cat("Pesho");
        house.addCat(cat);
        house.addCat(cat2);
        String expected = "The cat Misho, Pesho is in the house House!";
        Assert.assertEquals(expected, house.statistics());
    }


}
