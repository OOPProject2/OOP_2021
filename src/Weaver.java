public class Weaver extends WorkShop {
    public static final int WEAVER_BUILD_COST = 250;
    public static final int WEAVER_PRODUCE_TIME = 5;
    private static final String PRODUCT = "Fabric";
    private static final String REQUIRED_RAW_MATERIAL = "Feather";

    public Weaver() {
        super(WEAVER_BUILD_COST, WEAVER_PRODUCE_TIME, REQUIRED_RAW_MATERIAL);
    }

    @Override
    public String getWorkShopName() {
        return "Weaver";
    }

    @Override
    protected void workLevel1() {
        Event.addWorkingEvent(WEAVER_PRODUCE_TIME, PRODUCT, 1);
    }

    @Override
    protected void workLevel2Normal() {
        Event.addWorkingEvent(WEAVER_PRODUCE_TIME, PRODUCT, 2);
    }

    @Override
    protected void workLevel2Fast() {
        Event.addWorkingEvent((WEAVER_PRODUCE_TIME + 1) / 2, PRODUCT, 1);
    }
}
