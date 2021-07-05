package theatre.application.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import theatre.application.dao.AbstractDao;
import theatre.application.dao.TicketDao;
import theatre.application.model.Ticket;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
