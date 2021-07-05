package theatre.application.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import theatre.application.dao.AbstractDao;
import theatre.application.dao.TheatreHallDao;
import theatre.application.model.TheatreHall;

@Repository
public class TheatreHallDaoImpl extends AbstractDao<TheatreHall> implements TheatreHallDao {
    public TheatreHallDaoImpl(SessionFactory factory) {
        super(factory, TheatreHall.class);
    }
}
