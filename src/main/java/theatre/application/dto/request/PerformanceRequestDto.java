package theatre.application.dto.request;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PerformanceRequestDto {
    @NotNull
    private String performanceTitle;
    @Size(max = 200)
    private String performanceDescription;

    public String getPerformanceTitle() {
        return performanceTitle;
    }

    public String getPerformanceDescription() {
        return performanceDescription;
    }
}
