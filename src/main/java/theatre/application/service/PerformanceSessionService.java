package theatre.application.service;

import java.time.LocalDate;
import java.util.List;
import theatre.application.model.PerformanceSession;

public interface PerformanceSessionService {
    List<PerformanceSession> findAvailableSessions(Long performanceId, LocalDate date);

    PerformanceSession add(PerformanceSession session);

    PerformanceSession get(Long id);

    PerformanceSession update(PerformanceSession performanceSession);

    void delete(Long id);
}
