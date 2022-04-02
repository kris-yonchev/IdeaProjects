package softuni.exam.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import softuni.exam.models.entity.Offer;

import java.util.List;

@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {

    @Query("SELECT o FROM Offer o" +
            " JOIN o.agent a" +
            " JOIN o.apartment m" +
            " JOIN m.town t" +
            " WHERE m.apartmentType = 'three_rooms'" +
            " ORDER BY m.area DESC, o.price ASC")
    List<Offer> findByThreeRooms();
}
