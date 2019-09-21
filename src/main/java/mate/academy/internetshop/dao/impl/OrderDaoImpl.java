package mate.academy.internetshop.dao.impl;

import java.util.NoSuchElementException;

import mate.academy.internetshop.dao.OrderDao;
import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.model.Order;

public class OrderDaoImpl implements OrderDao {
    @Override
    public Order create(Order order) {
        Storage.orders.add(order);
        return order;
    }

    @Override
    public Order get(Long id) {
        return Storage.orders
                .stream()
                .filter(i -> i.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can’t find tem with id" + id));
    }

    @Override
    public Order update(Order order) {
        for (int i = 0; i < Storage.orders.size(); i++) {
            if (Storage.orders.get(i).equals(order)) {
                Storage.orders.set(i, order);
                return order;
            }
        }
        throw new NoSuchElementException();
    }

    @Override
    public void delete(Long id) {
        Storage.orders.removeIf(item -> item.getId().equals(id));
    }

    @Override
    public Order delete(Order order) {
        Storage.orders.removeIf(elem -> elem.equals(order));
        return order;
    }

    @Override
    public Order add(Order order) {
        Storage.orders.add(order);
        return order;
    }

/*    @Override
    public Order addOrder(Order order) {
        Storage.orders.add(order);
        return order;
    }*/
}
