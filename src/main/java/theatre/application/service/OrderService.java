package theatre.application.service;

import java.util.List;
import theatre.application.model.Order;
import theatre.application.model.ShoppingCart;
import theatre.application.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
