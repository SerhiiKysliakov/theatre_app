package theatre.application.dao;

import java.util.List;
import java.util.Optional;
import theatre.application.model.Performance;

public interface PerformanceDao {
    Performance add(Performance performance);

    Optional<Performance> get(Long id);

    List<Performance> getAll();
}
