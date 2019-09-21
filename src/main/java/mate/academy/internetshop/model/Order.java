package mate.academy.internetshop.model;

import mate.academy.internetshop.OrderIdGenerator;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private final Long id;
    private final Long userId;
    private List<Item> items = new ArrayList<>();

    public Order(Long userId, List<Item> items) {
        this.userId = userId;
        this.items = items;
        this.id = OrderIdGenerator.getGeneratedId();
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Order{" +
                "order id=" + id +
                ", userId=" + userId +
                ", items=" + items +
                '}';
    }
}
