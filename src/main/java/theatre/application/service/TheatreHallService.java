package theatre.application.service;

import java.util.List;
import theatre.application.model.TheatreHall;

public interface TheatreHallService {
    TheatreHall add(TheatreHall theatreHall);

    TheatreHall get(Long id);

    List<TheatreHall> getAll();
}
