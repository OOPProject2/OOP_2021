public class Shirt extends Product {
    private static final int SHIRT_PRICE = 100;
    private static final int REQUIRED_SPACE = 4;
    private static final int TIME_UNIT_TO_GET = 6;

    public Shirt() {
        super(SHIRT_PRICE, REQUIRED_SPACE, TIME_UNIT_TO_GET);
    }

    @Override
    public String getName() {
        return "Shirt";
    }
}
