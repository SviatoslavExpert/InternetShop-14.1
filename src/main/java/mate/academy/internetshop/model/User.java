package mate.academy.internetshop.model;

import java.util.ArrayList;
import java.util.List;

import mate.academy.internetshop.UserIdGenerator;

public class User {
    private final Long userId;
    private String name;
    private List<Order> orders = new ArrayList<>();

    public User() {
        this.userId = UserIdGenerator.getGeneratedId();
    }

    public Long getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public Long getId() {
        return userId;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
