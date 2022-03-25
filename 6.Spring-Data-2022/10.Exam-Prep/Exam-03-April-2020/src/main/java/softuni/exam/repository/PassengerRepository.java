package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.Passenger;

import java.util.List;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {

    Passenger findByEmail(String email);

    @Query(value = "SELECT p.first_name, p.last_name, p.email, p.phone_number, COUNT(t.id) AS ticket_count" +
            " FROM passengers AS p" +
            " JOIN tickets AS t ON t.passenger_id = p.id" +
            " GROUP BY p.id" +
            " ORDER BY ticket_count DESC, p.email ASC;", nativeQuery = true)
    List<String> findAllAndOrderByTicketsCountDescThenByEmail();
}
