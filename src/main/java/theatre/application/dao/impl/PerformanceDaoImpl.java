package theatre.application.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import theatre.application.dao.AbstractDao;
import theatre.application.dao.PerformanceDao;
import theatre.application.model.Performance;

@Repository
public class PerformanceDaoImpl extends AbstractDao<Performance> implements PerformanceDao {
    public PerformanceDaoImpl(SessionFactory factory) {
        super(factory, Performance.class);
    }
}
