public class Product {
    private final int PRICE;
    private final int REQUIRED_SPACE;
    private final int TIME_UNIT_TO_GET;
    private int remainingTime;

    public Product(int PRICE, int REQUIRED_SPACE, int TIME_UNIT_TO_GET) {
        this.PRICE = PRICE;
        this.REQUIRED_SPACE = REQUIRED_SPACE;
        this.TIME_UNIT_TO_GET = TIME_UNIT_TO_GET;
        remainingTime = TIME_UNIT_TO_GET;
    }
}
