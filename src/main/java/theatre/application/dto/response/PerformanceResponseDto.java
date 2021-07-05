package theatre.application.dto.response;

public class PerformanceResponseDto {
    private Long performanceId;
    private String performanceTitle;
    private String performanceDescription;

    public Long getPerformanceId() {
        return performanceId;
    }

    public void setPerformanceId(Long performanceId) {
        this.performanceId = performanceId;
    }

    public String getPerformanceTitle() {
        return performanceTitle;
    }

    public void setPerformanceTitle(String performanceTitle) {
        this.performanceTitle = performanceTitle;
    }

    public String getPerformanceDescription() {
        return performanceDescription;
    }

    public void setPerformanceDescription(String performanceDescription) {
        this.performanceDescription = performanceDescription;
    }
}
