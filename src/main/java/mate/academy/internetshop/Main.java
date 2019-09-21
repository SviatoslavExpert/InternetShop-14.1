package mate.academy.internetshop;

import java.util.List;

import mate.academy.internetshop.annotations.Inject;
import mate.academy.internetshop.annotations.Injector;
import mate.academy.internetshop.model.Bucket;
import mate.academy.internetshop.model.Item;
import mate.academy.internetshop.model.Order;
import mate.academy.internetshop.model.User;
import mate.academy.internetshop.service.BucketService;
import mate.academy.internetshop.service.ItemService;
import mate.academy.internetshop.service.OrderService;
import mate.academy.internetshop.service.UserService;

public class Main {

    static {
        try {
            Injector.injectDependency();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @Inject
    private static ItemService itemService;
    @Inject
    private static BucketService bucketService;
    @Inject
    private static OrderService orderService;
    @Inject
    private static UserService userService;

    public static void main(String[] args) {
        Item phone = new Item();
        phone.setName("iPhone 11");
        itemService.create(phone);
        Item tab = new Item();
        tab.setName("Samsung");
        itemService.create(tab);
        Item laptop = new Item();
        laptop.setName("Mi");
        itemService.create(laptop);
        Item tv = new Item();
        tv.setName("Lenovo");
        itemService.create(tv);

        User mike = new User();
        userService.create(mike);
        User tom = new User();
        userService.create(tom);

        Bucket bucketOne = new Bucket(mike.getUserId());
        bucketService.create(bucketOne);
        bucketService.addItem(bucketOne.getId(), phone.getId());
        bucketService.addItem(bucketOne.getId(), tab.getId());
        System.out.println("All items in Mike's bucketOne (getAllItems): ");
        System.out.println(bucketService.getAllItems(bucketOne.getId()));
        System.out.println();
        System.out.println("All items in Mike's bucketOne are cleared (clear): ");
        System.out.println(bucketService.clear(bucketOne.getId()));
        System.out.println();
        bucketService.addItem(bucketOne.getId(), laptop.getId());
        bucketService.addItem(bucketOne.getId(), tv.getId());
        System.out.println("All items in Mike's bucketOne (getAllItems): ");
        System.out.println(bucketService.getAllItems(bucketOne.getId()));

        System.out.println();
        System.out.println("Order 1 (completeOrder): ");
        Order order = new Order(mike.getUserId(), bucketOne.getItems());
        orderService.create(order);
        System.out.println(orderService.completeOrder(mike.getUserId(), bucketOne.getItems()));
        System.out.println();
        bucketService.clear(bucketOne.getId());

        bucketService.addItem(bucketOne.getId(), phone.getId());
        bucketService.addItem(bucketOne.getId(), tab.getId());
        bucketService.getAllItems(bucketOne.getId());
        orderService.delete(order);
        System.out.println("Order 2 (completeOrder): ");
        System.out.println(orderService.completeOrder(mike.getUserId(), bucketOne.getItems()));
        System.out.println();

        System.out.println("Mike's getAllOrdersForUser method: ");
        List<Order> allOrdersForUserMike = orderService.getAllOrdersForUser(mike.getId());
        allOrdersForUserMike.forEach(System.out::println);
    }
}
