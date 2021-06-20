public class Milk extends Product {
    private static final int MILK_PRICE = 25;
    private static final int REQUIRED_SPACE = 1;
    private static final int TIME_UNIT_TO_GET = 4;

    public Milk() {
        super(MILK_PRICE, REQUIRED_SPACE, TIME_UNIT_TO_GET);
    }

    @Override
    public String getName() {
        return "Milk";
    }
}
