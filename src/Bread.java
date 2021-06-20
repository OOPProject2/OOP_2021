public class Bread extends Product {
    private static final int BREAD_PRICE = 80;
    private static final int REQUIRED_SPACE = 4;
    private static final int TIME_UNIT_TO_GET = 6;

    public Bread() {
        super(BREAD_PRICE, REQUIRED_SPACE, TIME_UNIT_TO_GET);
    }

    @Override
    public String getName() {
        return "Bread";
    }
}
