package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;



public class AquariumTests {

    private Aquarium aquarium;


    @Before
    public void prep() {
        this.aquarium = new Aquarium("TestAquarium", 10);

    }

    @Test(expected = NullPointerException.class)
    public void testShouldReturnExceptionIfNameIsNull() {
        Aquarium nullName = new Aquarium(null, 100);
    }

    @Test(expected = NullPointerException.class)
    public void testShouldReturnExceptionForEmptyName() {
        Aquarium emptyName = new Aquarium("   ", 100);
    }

    @Test
    public void testForNameSetter() {
        Assert.assertEquals("TestAquarium", aquarium.getName());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForCapacityUnder0ShouldReturnException() {
        Aquarium negativeCapacity = new Aquarium("Negative", -1);
    }

    @Test
    public void testForCapacitySetter() {
        Aquarium aquarium = new Aquarium("Aquarium", 1);
        Assert.assertEquals(1, aquarium.getCapacity());
    }

    @Test
    public void testAddCommand() {
        Aquarium aquarium = new Aquarium("Aquarium", 3);
        aquarium.add(new Fish("FishOne"));
        aquarium.add(new Fish("FishTwo"));
        aquarium.add(new Fish("FishThree"));
        Assert.assertEquals(3, aquarium.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForAquariumTooSmall() {
        Aquarium aquarium = new Aquarium("Aquarium", 2);
        Fish fish = new Fish("Fish1");
        Fish fish2 = new Fish("Fish2");
        Fish fish3 = new Fish("Fish3");
        aquarium.add(fish);
        aquarium.add(fish2);
        aquarium.add(fish3);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShouldThrowExceptionForNullFish() {
        aquarium.remove("Fash");
    }

    @Test
    public void testFishRemovalMethod() {
        aquarium.add(new Fish("Fish"));
        Assert.assertEquals(1, aquarium.getCount());
        aquarium.remove("Fish");
        Assert.assertEquals(0, aquarium.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testForSellingMissingFishException() {
        aquarium.sellFish("Fash");
    }

    @Test
    public void testForSellFishMethod() {
        Fish fish = new Fish("Pesho");
        aquarium.add(fish);
        Fish required = new Fish("Pesho");
        aquarium.sellFish("Pesho");
        Assert.assertFalse(fish.isAvailable());
        Assert.assertEquals(fish.getName(), required.getName());

    }

    @Test
    public void testReportMethod() {
        Aquarium aquarium = new Aquarium("Aquarium", 3);
        Fish fishOne = new Fish("Pesho");
        Fish fishTwo = new Fish("Misho");
        aquarium.add(fishOne);
        aquarium.add(fishTwo);
        String expected = "Fish available at Aquarium: Pesho, Misho";
        Assert.assertEquals(expected, aquarium.report());
    }


    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium
}

