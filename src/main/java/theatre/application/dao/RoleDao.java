package theatre.application.dao;

import java.util.Optional;
import theatre.application.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getRoleByName(String roleName);
}
