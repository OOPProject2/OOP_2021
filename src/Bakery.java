public class Bakery extends WorkShop {
    public static final int BAKERY_BUILD_COST = 250;
    public static final int BAKERY_PRODUCE_TIME = 5;
    private static final String PRODUCT = "Bread";
    private static final String REQUIRED_RAW_MATERIAL = "Flour";

    public Bakery() {
        super(BAKERY_BUILD_COST, BAKERY_PRODUCE_TIME, REQUIRED_RAW_MATERIAL);
    }

    @Override
    public String getWorkShopName() {
        return "Bakery";
    }

    @Override
    protected void workLevel1() {
        Event.addWorkingEvent(BAKERY_PRODUCE_TIME, PRODUCT, 1);
    }

    @Override
    protected void workLevel2Normal() {
        Event.addWorkingEvent(BAKERY_PRODUCE_TIME, PRODUCT, 2);
    }

    @Override
    protected void workLevel2Fast() {
        Event.addWorkingEvent((BAKERY_PRODUCE_TIME + 1) / 2, PRODUCT, 1);
    }
}
