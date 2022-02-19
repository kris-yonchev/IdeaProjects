package unitTesting.rpg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AxeTest {

    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 10;

    private Axe axe;
    private Dummy dummy;
    private Axe brokenAxe;

    @Before
    public void prep() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(100, 100);
        this.brokenAxe = new Axe(AXE_ATTACK, 0);
    }

    @Test
    public void weaponLosesDurabilityAfterAttack() {
        axe.attack(dummy);

        Assert.assertEquals(AXE_DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void attackingWithABrokenWeaponShouldThrowException() {
        brokenAxe.attack(dummy);
    }

}