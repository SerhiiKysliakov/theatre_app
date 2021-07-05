package theatre.application.service;

import theatre.application.model.Role;

public interface RoleService {
    void add(Role role);

    Role getRoleByName(String roleName);
}
