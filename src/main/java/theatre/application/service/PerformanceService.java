package theatre.application.service;

import java.util.List;
import theatre.application.model.Performance;

public interface PerformanceService {
    Performance add(Performance performance);

    Performance get(Long id);

    List<Performance> getAll();
}
