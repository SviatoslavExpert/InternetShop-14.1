package mate.academy.internetshop.dao.impl;

import java.util.NoSuchElementException;

import mate.academy.internetshop.dao.Storage;
import mate.academy.internetshop.dao.UserDao;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;

public class UserDaoImpl implements UserDao {
    @Override
    public User create(User user) {
        Storage.users.add(user);
        return user;
    }

    @Override
    public User get(Long id) {
        return Storage.users.stream()
                .filter(u -> u.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException("Can't find user with id " + id));
    }

    @Override
    public User update(User user) {
        User updatedUser = get(user.getId());
        updatedUser.setOrders(user.getOrders());
        return updatedUser;
    }

    @Override
    public User delete(Long id) {
        Storage.users
                .removeIf(u -> u.getId().equals(id));
        return null;
    }

    @Override
    public void delete(User user) {
        Storage.users.removeIf(elem -> elem.equals(user));
    }

    @Override
    public User addUser(User user) {
        Storage.users.add(user);
        return user;
    }

    @Override
    public void addOrder(Order order) {
        Storage.orders.add(order);
    }
}
