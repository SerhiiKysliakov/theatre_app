package theatre.application.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    private PerformanceSession performanceSession;
    @OneToOne(fetch = FetchType.LAZY)
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PerformanceSession getPerformanceSession() {
        return performanceSession;
    }

    public void setPerformanceSession(PerformanceSession performanceSession) {
        this.performanceSession = performanceSession;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Ticket{"
                + "id=" + id
                + ", performanceSession=" + performanceSession
                + ", user=" + user + '}';
    }
}
