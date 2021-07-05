package theatre.application.controller;

import java.util.Set;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import theatre.application.model.Role;
import theatre.application.model.User;
import theatre.application.service.AuthenticationService;
import theatre.application.service.RoleService;
import theatre.application.service.UserService;

@RestController
@RequestMapping("/inject")
public class InjectController {
    private final RoleService roleService;
    private final UserService userService;
    private final AuthenticationService authenticationService;

    public InjectController(RoleService roleService, UserService userService,
                            AuthenticationService authenticationService) {
        this.roleService = roleService;
        this.userService = userService;
        this.authenticationService = authenticationService;
    }

    @GetMapping
    public String inject() {
        Role adminRole = new Role();
        adminRole.setRoleName(Role.RoleName.ADMIN);
        roleService.add(adminRole);
        Role userRole = new Role();
        userRole.setRoleName(Role.RoleName.USER);
        roleService.add(userRole);
        authenticationService.register("bob@gmail.com", "1234");

        User user = new User();
        user.setEmail("alice@gmail.com");
        user.setPassword("1234");
        user.setRoles(Set.of(adminRole));
        userService.add(user);
        return "Done";
    }
}
