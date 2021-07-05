package theatre.application.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import theatre.application.dao.PerformanceDao;
import theatre.application.exception.DataProcessingException;
import theatre.application.model.Performance;
import theatre.application.service.PerformanceService;

@Service
public class PerformanceServiceImpl implements PerformanceService {
    private final PerformanceDao performanceDao;

    public PerformanceServiceImpl(PerformanceDao performanceDao) {
        this.performanceDao = performanceDao;
    }

    @Override
    public Performance add(Performance performance) {
        return performanceDao.add(performance);
    }

    @Override
    public Performance get(Long id) {
        return performanceDao.get(id).orElseThrow(
                () -> new DataProcessingException("Can't get performance by id " + id));
    }

    @Override
    public List<Performance> getAll() {
        return performanceDao.getAll();
    }
}
