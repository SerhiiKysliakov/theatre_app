package theatre.application.service.impl;

import org.springframework.stereotype.Service;
import theatre.application.dao.RoleDao;
import theatre.application.exception.DataProcessingException;
import theatre.application.model.Role;
import theatre.application.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public void add(Role role) {
        roleDao.add(role);
    }

    @Override
    public Role getRoleByName(String roleName) {
        return roleDao.getRoleByName(roleName)
                .orElseThrow(() -> new DataProcessingException("Role " + roleName + " not found"));
    }
}
