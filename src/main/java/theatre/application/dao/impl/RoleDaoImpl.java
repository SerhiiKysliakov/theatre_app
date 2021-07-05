package theatre.application.dao.impl;

import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;
import theatre.application.dao.AbstractDao;
import theatre.application.dao.RoleDao;
import theatre.application.exception.DataProcessingException;
import theatre.application.model.Role;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getRoleByName(String roleName) {
        try (Session session = factory.openSession()) {
            return session.createQuery("FROM Role WHERE roleName = :name", Role.class)
                    .setParameter("name", Role.RoleName.valueOf(roleName))
                    .uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException(roleName + " does not exist", e);
        }
    }
}
