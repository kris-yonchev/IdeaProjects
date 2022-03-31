package softuni.exam.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import softuni.exam.domain.entities.Player;

import java.math.BigDecimal;
import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {

    @Query("SELECT p FROM Player p" +
            " WHERE p.team.name = 'North Hub'" +
            " ORDER BY p.id ASC")
    List<Player> findAllFromTeam();

    List<Player> findAllBySalaryGreaterThanOrderBySalaryDesc(BigDecimal i);
}
