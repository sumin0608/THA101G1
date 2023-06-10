package tw.idv.ixercise.event.repository;

import org.springframework.data.jpa.repository.*;
import tw.idv.ixercise.event.entity.*;

public interface AttendeesRepository extends JpaRepository<Attendees, Integer> {

}
