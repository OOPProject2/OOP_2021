public class Bakery extends WorkShop{
    public static final int BAKERY_BUILD_COST = 250;
    public static final int BAKERY_PRODUCE_TIME = 5;
    private static final String PRODUCT = "Bread";
    private static final String REQUIRED_RAW_MATERIAL = "Flour";

    public Bakery() {
        super(BAKERY_BUILD_COST, BAKERY_PRODUCE_TIME);
    }
}
