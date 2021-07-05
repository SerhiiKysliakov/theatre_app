package theatre.application.service;

import theatre.application.model.PerformanceSession;
import theatre.application.model.ShoppingCart;
import theatre.application.model.User;

public interface ShoppingCartService {
    void addSession(PerformanceSession performanceSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
