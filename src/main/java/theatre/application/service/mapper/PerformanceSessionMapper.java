package theatre.application.service.mapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.springframework.stereotype.Component;
import theatre.application.dto.request.PerformanceSessionRequestDto;
import theatre.application.dto.response.PerformanceSessionResponseDto;
import theatre.application.model.PerformanceSession;
import theatre.application.service.PerformanceService;
import theatre.application.service.TheatreHallService;
import theatre.application.util.DateTimePatternUtil;

@Component
public class PerformanceSessionMapper implements
        RequestDtoMapper<PerformanceSessionRequestDto, PerformanceSession>,
        ResponseDtoMapper<PerformanceSessionResponseDto, PerformanceSession> {
    private final DateTimeFormatter formatter =
            DateTimeFormatter.ofPattern(DateTimePatternUtil.DATE_TIME_PATTERN);
    private final TheatreHallService theatreHallService;
    private final PerformanceService performanceService;

    public PerformanceSessionMapper(TheatreHallService theatreHallService,
                                    PerformanceService performanceService) {
        this.theatreHallService = theatreHallService;
        this.performanceService = performanceService;
    }

    @Override
    public PerformanceSession mapToModel(PerformanceSessionRequestDto dto) {
        PerformanceSession performanceSession = new PerformanceSession();
        performanceSession.setPerformance(performanceService.get(dto.getPerformanceId()));
        performanceSession.setTheatreHall(theatreHallService.get(dto.getTheatreHallId()));
        performanceSession.setShowTime(LocalDateTime.parse(dto.getShowTime(), formatter));
        return performanceSession;
    }

    @Override
    public PerformanceSessionResponseDto mapToDto(PerformanceSession performanceSession) {
        PerformanceSessionResponseDto responseDto = new PerformanceSessionResponseDto();
        responseDto.setPerformanceSessionId(performanceSession.getId());
        responseDto.setTheatreHallId(performanceSession.getTheatreHall().getId());
        responseDto.setPerformanceId(performanceSession.getPerformance().getId());
        responseDto.setPerformanceTitle(performanceSession.getPerformance().getTitle());
        responseDto.setShowTime(performanceSession.getShowTime().format(formatter));
        return responseDto;
    }
}
