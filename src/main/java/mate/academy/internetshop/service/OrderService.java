package mate.academy.internetshop.service;

import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.model.Order;

import java.util.List;

public interface OrderService {

    Order create(Order order);

    Order get(Long id);

    Order update(Order order);

    void delete(Long id);

    void delete(Order order);

    Order completeOrder(Long userId, List<Item> items);

    List<Order> getAllOrdersForUser(Long userId);

}
