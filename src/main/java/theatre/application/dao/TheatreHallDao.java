package theatre.application.dao;

import java.util.List;
import java.util.Optional;
import theatre.application.model.TheatreHall;

public interface TheatreHallDao {
    TheatreHall add(TheatreHall theatreHall);

    Optional<TheatreHall> get(Long id);

    List<TheatreHall> getAll();
}
