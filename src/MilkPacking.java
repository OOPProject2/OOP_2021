public class MilkPacking extends WorkShop {
    public static final int MILK_PACKING_BUILD_COST = 400;
    public static final int MILK_PACKING_PRODUCE_TIME = 6;
    private static final String PRODUCT = "PackedMilk";
    private static final String REQUIRED_RAW_MATERIAL = "Milk";

    public MilkPacking() {
        super(MILK_PACKING_BUILD_COST, MILK_PACKING_PRODUCE_TIME, REQUIRED_RAW_MATERIAL);
    }

    @Override
    public String getWorkShopName() {
        return "MilkPacking";
    }

    @Override
    protected void workLevel1() {
        Event.addWorkingEvent(MILK_PACKING_PRODUCE_TIME, PRODUCT, 1);
    }

    @Override
    protected void workLevel2Normal() {
        Event.addWorkingEvent(MILK_PACKING_PRODUCE_TIME, PRODUCT, 2);
    }

    @Override
    protected void workLevel2Fast() {
        Event.addWorkingEvent(MILK_PACKING_PRODUCE_TIME / 2, PRODUCT, 1);
    }
}
