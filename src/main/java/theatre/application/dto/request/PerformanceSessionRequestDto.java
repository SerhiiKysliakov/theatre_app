package theatre.application.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

public class PerformanceSessionRequestDto {
    @Positive
    private Long performanceId;
    @Positive
    private Long theatreHallId;
    @NotNull
    private String showTime;

    public Long getPerformanceId() {
        return performanceId;
    }

    public Long getTheatreHallId() {
        return theatreHallId;
    }

    public String getShowTime() {
        return showTime;
    }
}
