package theatre.application.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import theatre.application.dao.TheatreHallDao;
import theatre.application.exception.DataProcessingException;
import theatre.application.model.TheatreHall;
import theatre.application.service.TheatreHallService;

@Service
public class TheatreHallServiceImpl implements TheatreHallService {
    private final TheatreHallDao theatreHallDao;

    public TheatreHallServiceImpl(TheatreHallDao theatreHallDao) {
        this.theatreHallDao = theatreHallDao;
    }

    @Override
    public TheatreHall add(TheatreHall theatreHall) {
        return theatreHallDao.add(theatreHall);
    }

    @Override
    public TheatreHall get(Long id) {
        return theatreHallDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get theatre hall by id " + id));
    }

    @Override
    public List<TheatreHall> getAll() {
        return theatreHallDao.getAll();
    }
}
