package unitTesting.rpg;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DummyTest {

    private static final int DUMMY_HP = 100;
    private static final int DUMMY_EXP = 100;

    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void prep() {
        this.dummy = new Dummy(DUMMY_HP, DUMMY_EXP);
        this.deadDummy = new Dummy(0, DUMMY_EXP);
    }

    @Test
    public void dummyShouldLoseHpOnBeingAttacked() {
        dummy.takeAttack(1);
        Assert.assertEquals(DUMMY_HP - 1, dummy.getHealth());
    }

    @Test (expected = IllegalStateException.class)
    public void deadDummyShouldThrowExceptionIfAttacked() {
        deadDummy.takeAttack(1);
    }

    @Test
    public void deadDummyShouldGiveExp() {
        int actual = deadDummy.giveExperience();
        Assert.assertEquals(DUMMY_EXP, actual);
    }

    @Test (expected = IllegalStateException.class)
    public void aliveDummyShouldNotGiveExp() {
        dummy.giveExperience();
    }

}