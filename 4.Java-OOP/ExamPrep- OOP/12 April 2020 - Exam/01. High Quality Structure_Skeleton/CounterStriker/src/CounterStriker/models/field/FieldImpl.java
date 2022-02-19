package CounterStriker.models.field;

import CounterStriker.models.guns.Gun;
import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.COUNTER_TERRORIST_WINS;
import static CounterStriker.common.OutputMessages.TERRORIST_WINS;

public class FieldImpl implements Field {


    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = players.stream().filter(p -> p.getClass().getSimpleName().equals("Terrorist")).collect(Collectors.toList());

        List<Player> cts = players.stream().filter(p -> p.getClass().getSimpleName().equals("CounterTerrorist")).collect(Collectors.toList());

        boolean tWin = false;
        boolean fight = true;
        while (fight) {

            for (Player terrorist : terrorists) {
                for (Player ct : cts) {
                    if (terrorist.isAlive()) {
                        Gun gun = terrorist.getGun();
                        ct.takeDamage(gun.fire());
                    }
                }
            }

            for (Player ct : cts) {
                for (Player terrorist : terrorists) {
                    if (ct.isAlive()) {
                        Gun gun = ct.getGun();
                        terrorist.takeDamage(gun.fire());
                    }
                }
            }

            if (terrorists.stream().noneMatch(Player::isAlive)) {
                fight = false;
            }

            if (cts.stream().noneMatch(Player::isAlive)) {
                tWin = true;
                fight = false;
            }

        }
        if (tWin) {
            return TERRORIST_WINS;
        } else {
            return COUNTER_TERRORIST_WINS;
        }
    }
}
