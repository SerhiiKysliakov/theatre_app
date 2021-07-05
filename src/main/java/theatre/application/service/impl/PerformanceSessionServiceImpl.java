package theatre.application.service.impl;

import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;
import theatre.application.dao.PerformanceSessionDao;
import theatre.application.exception.DataProcessingException;
import theatre.application.model.PerformanceSession;
import theatre.application.service.PerformanceSessionService;

@Service
public class PerformanceSessionServiceImpl implements PerformanceSessionService {
    private final PerformanceSessionDao performanceSessionDao;

    public PerformanceSessionServiceImpl(PerformanceSessionDao performanceSessionDao) {
        this.performanceSessionDao = performanceSessionDao;
    }

    @Override
    public List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date) {
        return performanceSessionDao.findAvailableSessions(performanceId, date);
    }

    @Override
    public PerformanceSession add(PerformanceSession session) {
        return performanceSessionDao.add(session);
    }

    @Override
    public PerformanceSession get(Long id) {
        return performanceSessionDao.get(id).orElseThrow(
                () -> new DataProcessingException("Session with id " + id + " not found"));
    }

    @Override
    public PerformanceSession update(PerformanceSession performanceSession) {
        return performanceSessionDao.update(performanceSession);
    }

    @Override
    public void delete(Long id) {
        performanceSessionDao.delete(id);
    }
}
