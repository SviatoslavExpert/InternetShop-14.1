package mate.academy.internetshop;

public class OrderIdGenerator {
    private static Long idGenerator = 0L;

    private OrderIdGenerator() {
    }

    public static Long getGeneratedId() {
        return idGenerator++;
    }
}
