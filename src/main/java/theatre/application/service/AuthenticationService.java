package theatre.application.service;

import theatre.application.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
