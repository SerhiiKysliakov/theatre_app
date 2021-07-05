package theatre.application.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import javax.validation.Valid;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import theatre.application.dto.request.PerformanceSessionRequestDto;
import theatre.application.dto.response.PerformanceSessionResponseDto;
import theatre.application.model.PerformanceSession;
import theatre.application.service.PerformanceSessionService;
import theatre.application.service.mapper.PerformanceSessionMapper;
import theatre.application.util.DateTimePatternUtil;

@RestController
@RequestMapping("/performance-sessions")
public class PerformanceSessionController {
    public static final String DATE_PATTERN = DateTimePatternUtil.DATE_PATTERN;
    private final PerformanceSessionService performanceSessionService;
    private final PerformanceSessionMapper performanceSessionMapper;

    public PerformanceSessionController(PerformanceSessionService performanceSessionService,
                                        PerformanceSessionMapper performanceSessionMapper) {
        this.performanceSessionService = performanceSessionService;
        this.performanceSessionMapper = performanceSessionMapper;
    }

    @PostMapping
    public PerformanceSessionResponseDto add(@RequestBody
                                                 @Valid PerformanceSessionRequestDto requestDto) {
        PerformanceSession performanceSession = performanceSessionMapper.mapToModel(requestDto);
        performanceSessionService.add(performanceSession);
        return performanceSessionMapper.mapToDto(performanceSession);
    }

    @GetMapping("/available")
    public List<PerformanceSessionResponseDto> getAll(@RequestParam Long movieId,
                                                      @RequestParam
                                                @DateTimeFormat(pattern = DATE_PATTERN)
                                                        LocalDate date) {
        return performanceSessionService.findAvailableSessions(movieId, date)
                .stream()
                .map(performanceSessionMapper::mapToDto)
                .collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    public PerformanceSessionResponseDto update(@PathVariable Long id,
                                                @RequestBody
                                                @Valid PerformanceSessionRequestDto requestDto) {
        PerformanceSession performanceSession = performanceSessionMapper.mapToModel(requestDto);
        performanceSession.setId(id);
        performanceSessionService.update(performanceSession);
        return performanceSessionMapper.mapToDto(performanceSession);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        performanceSessionService.delete(id);
    }
}
