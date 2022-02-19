package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class PlayerTests {

    Player player;
    String name = "Pesho";
    int hp = 10;

    @Before
    public void prep() {
        player = new Player(name, hp);
    }


    @Test
    public void testConstructorShouldMakeNewPlayer() {
        Assert.assertEquals("Pesho", player.getUsername());
    }

    @Test(expected = NullPointerException.class)
    public void testNameShouldNotBeNull() {
        player = new Player(null, 10);
    }

    @Test(expected = NullPointerException.class)
    public void testForNameLengthLessThan1() {
        player = new Player("  ", 10);
    }

    @Test
    public void testHealthGetter() {
        Assert.assertEquals(10, player.getHealth());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testHealthShouldThrowExceptionIfBelow0() {
        player = new Player("Pesho", -1);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testUnmodifiableCollectionThrowsException() {
        player.getGuns().add(new Gun("Gun", 2));
    }

    @Test
    public void testGetGunsReturnsListOfGuns() {
        Gun gun = new Gun("AK", 2);
        Gun gun2 = new Gun("AWP", 2);
        player.addGun(gun);
        player.addGun(gun2);
        List<Gun> expected = List.of(gun, gun2);
        List<Gun> actual = player.getGuns();
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testPlayerTakesDmg() {
        player.takeDamage(2);
        Assert.assertEquals(8, player.getHealth());
    }

    @Test
    public void testPlayerReceivesKillingBlow() {
        player.takeDamage(11);
        Assert.assertEquals(0, player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testPlayerIsDead() {
        player = new Player("Pesho", 0);
        player.takeDamage(5);
    }

    @Test(expected = NullPointerException.class)
    public void testGunIsNullThrowsException() {
        player.addGun(null);
    }

    @Test
    public void testAddGunMethod() {
        Gun newGun = new Gun("AK", 47);
        player.addGun(newGun);
        Assert.assertEquals(newGun, player.getGun("AK"));
    }

    @Test
    public void testRemoveGun() {
        Gun gun = new Gun("Gun", 2);
        Gun gun2 = new Gun("Pistol", 2);
        player.addGun(gun);
        player.addGun(gun2);
        Assert.assertTrue(player.removeGun(gun));
        Assert.assertFalse(player.removeGun(gun));
        Assert.assertEquals(1, player.getGuns().size());
        Assert.assertEquals(gun2, player.getGuns().get(0));
    }

    @Test
    public void testGetGunMethod() {
        Gun gun = new Gun("Ak", 20);
        player.addGun(gun);
        player.getGun("Ak");
    }

    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Player
}
