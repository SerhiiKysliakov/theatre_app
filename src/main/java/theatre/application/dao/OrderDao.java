package theatre.application.dao;

import java.util.List;
import theatre.application.model.Order;
import theatre.application.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
