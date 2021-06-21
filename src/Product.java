import java.util.Random;

public class Product {
    private final int PRICE;
    private final int REQUIRED_SPACE;
    private final int TIME_UNIT_TO_GET;
    private int remainingTime;
    private int productXLocInGameField = 0;
    private int productYLocInGameField = 0;

    public Product(int PRICE, int REQUIRED_SPACE, int TIME_UNIT_TO_GET) {
        this.PRICE = PRICE;
        this.REQUIRED_SPACE = REQUIRED_SPACE;
        this.TIME_UNIT_TO_GET = TIME_UNIT_TO_GET;
        remainingTime = TIME_UNIT_TO_GET;
        Random random = new Random();
        productXLocInGameField = random.nextInt(6) + 1;
        productYLocInGameField = random.nextInt(6) + 1;
        Event.addToDisappearProductEvent(TIME_UNIT_TO_GET, this);
    }

    public boolean isCollected() {
        return productXLocInGameField == 0 && productYLocInGameField == 0;
    }

    public int getProductXLocInGameField() {
        return productXLocInGameField;
    }

    public int getProductYLocInGameField() {
        return productYLocInGameField;
    }

    public String getName() {
        return "Product";
    }

    public void collect() {
        this.productYLocInGameField = 0;
        this.productXLocInGameField = 0;
    }

    public int getREQUIRED_SPACE() {
        return REQUIRED_SPACE;
    }

    public int getPRICE() {
        return PRICE;
    }
}
