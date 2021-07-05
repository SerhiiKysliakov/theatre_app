package theatre.application.model;

import java.time.LocalDateTime;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PerformanceSession {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Performance performance;
    @ManyToOne
    private TheatreHall theatreHall;
    private LocalDateTime showTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Performance getPerformance() {
        return performance;
    }

    public void setPerformance(Performance performance) {
        this.performance = performance;
    }

    public TheatreHall getTheatreHall() {
        return theatreHall;
    }

    public void setTheatreHall(TheatreHall theatreHall) {
        this.theatreHall = theatreHall;
    }

    public LocalDateTime getShowTime() {
        return showTime;
    }

    public void setShowTime(LocalDateTime showTime) {
        this.showTime = showTime;
    }

    @Override
    public String toString() {
        return "PerformanceSession{"
                + "id=" + id
                + ", performance=" + performance
                + ", theatreHall=" + theatreHall
                + ", showTime=" + showTime + '}';
    }
}
