package unitTesting.rpg;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroTest {

    private Hero hero;

    @Before
    public void prep() {
        Weapon mockedWeap = Mockito.mock(Weapon.class);
        this.hero = new Hero("Pesho", mockedWeap);
    }


    @Test
    public void attackerGainsExpOnTargetDeath() {
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(100);

        this.hero.attack(mockedTarget);

        assertEquals(100, this.hero.getExperience());
    }

    @Test
    public void attackerShouldGainNoExpWhenTargetIsAlive() {
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(false);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(100);

        this.hero.attack(mockedTarget);

        assertEquals(0, this.hero.getExperience());
    }

}