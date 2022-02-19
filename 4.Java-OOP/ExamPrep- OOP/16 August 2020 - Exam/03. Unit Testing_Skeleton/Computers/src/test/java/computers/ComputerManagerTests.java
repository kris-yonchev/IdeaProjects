package computers;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ComputerManagerTests {

    ComputerManager computerManager;

    @Before
    public void prep() {
        computerManager = new ComputerManager();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiableListShouldThrowException() {
        Computer computer = new Computer("Pepega", "Z2x", 200);
        computerManager.getComputers().add(computer);
    }

    @Test
    public void testShouldReturnComputerManagerSize() {
        Computer computer = new Computer("Pepega", "Z2x", 200);
        computerManager.addComputer(computer);
        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNullNameShouldThrowIAE() {
        Computer computer = null;
        computerManager.addComputer(computer);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForComputerAlreadyInCollection() {
        Computer computer = new Computer("Pepega", "Z2x", 200);
        Computer computer2 = new Computer("Pepega", "Z2x", 200);
        computerManager.addComputer(computer);
        computerManager.addComputer(computer2);
    }

    @Test
    public void testAddMethod() {
        Computer computer = new Computer("Pepega", "Z2x", 200);
        computerManager.addComputer(computer);
        Assert.assertEquals(computer, computerManager.getComputer("Pepega", "Z2x"));
    }

    @Test
    public void testRemoveMethod() {
        Computer computer = new Computer("Pepega", "Z2x", 200);
        Computer computer2 = new Computer("ASUS", "Pro", 300);
        computerManager.addComputer(computer);
        computerManager.addComputer(computer2);
        Assert.assertEquals(computer, computerManager.removeComputer("Pepega", "Z2x"));
        Assert.assertEquals(computer2, computerManager.getComputer("ASUS", "Pro"));
        Assert.assertEquals(1, computerManager.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForNullManufacturerThrowsException() {
        computerManager.getComputer(null, "test_model");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForNullModelThrowsException() {
        computerManager.getComputer("test_manufacturer", null);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testForComputerNotExistingInCollectionThrowsException() {
        computerManager.getComputer("Pepega", "Z2x");
    }

    @Test
    public void testGetComputerMethod() {
        Computer computer = new Computer("Pepega", "Z2x", 200);
        computerManager.addComputer(computer);
        computerManager.getComputer("Pepega", "Z2x");
    }

    @Test
    public void testGetByManufacturer() {
        Computer computer = new Computer("Pepega", "Z2x", 200);
        Computer computer2 = new Computer("Pepega", "XD2", 250);
        computerManager.addComputer(computer);
        computerManager.addComputer(computer2);
        List<Computer> expected = new ArrayList<>();
        expected.add(computer);
        expected.add(computer2);
        Assert.assertEquals(expected, computerManager.getComputersByManufacturer("Pepega"));

    }


    // TODO: Test ComputerManager
}