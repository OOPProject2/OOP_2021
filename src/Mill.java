public class Mill extends WorkShop {
    public static final int MILL_BUILD_COST = 150;
    public static final int MILL_PRODUCE_TIME = 4;
    private static final String PRODUCT = "Egg";
    private static final String REQUIRED_RAW_MATERIAL = "Flour";

    public Mill() {
        super(MILL_BUILD_COST, MILL_PRODUCE_TIME, REQUIRED_RAW_MATERIAL);
    }

    @Override
    public String getWorkShopName() {
        return "Mill";
    }

    @Override
    protected void workLevel1() {
        Event.addWorkingEvent(MILL_PRODUCE_TIME, PRODUCT, 1);
    }

    @Override
    protected void workLevel2Normal() {
        Event.addWorkingEvent(MILL_PRODUCE_TIME, PRODUCT, 2);
    }

    @Override
    protected void workLevel2Fast() {
        Event.addWorkingEvent(MILL_PRODUCE_TIME / 2, PRODUCT, 1);
    }
}
