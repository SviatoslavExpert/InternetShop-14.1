package mate.academy.internetshop.dao;

import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;

public interface UserDao {

    User create(User user);

    User get(Long id);

    User update(User user);

    User delete(Long id);

    void delete(User user);

    User addUser(User user);

    void addOrder(Order order);
}
