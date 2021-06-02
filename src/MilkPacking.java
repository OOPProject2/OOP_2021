public class MilkPacking extends WorkShop{
    public static final int MILK_PACKING_BUILD_COST = 400;
    public static final int MILK_PACKING_PRODUCE_TIME = 6;
    private static final String PRODUCT = "PackedMilk";
    private static final String REQUIRED_RAW_MATERIAL = "Milk";

    public MilkPacking() {
        super(MILK_PACKING_BUILD_COST, MILK_PACKING_PRODUCE_TIME);
    }
}
