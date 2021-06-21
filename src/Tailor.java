public class Tailor extends WorkShop {
    public static final int TAILOR_BUILD_COST = 400;
    public static final int TAILOR_PRODUCE_TIME = 6;
    private static final String PRODUCT = "Shirt";
    private static final String REQUIRED_RAW_MATERIAL = "Fabric";

    public Tailor() {
        super(TAILOR_BUILD_COST, TAILOR_PRODUCE_TIME, REQUIRED_RAW_MATERIAL);
    }

    @Override
    public String getWorkShopName() {
        return "Tailor";
    }

    @Override
    protected void workLevel1() {
        Event.addWorkingEvent(TAILOR_PRODUCE_TIME, PRODUCT, 1);
    }

    @Override
    protected void workLevel2Normal() {
        Event.addWorkingEvent(TAILOR_PRODUCE_TIME, PRODUCT, 2);
    }

    @Override
    protected void workLevel2Fast() {
        Event.addWorkingEvent(TAILOR_PRODUCE_TIME / 2, PRODUCT, 1);
    }
}
