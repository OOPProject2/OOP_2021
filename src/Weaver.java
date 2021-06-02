public class Weaver extends WorkShop{
    public static final int WEAVER_BUILD_COST = 250;
    public static final int WEAVER_PRODUCE_TIME = 5;
    private static final String PRODUCT = "Fabric";
    private static final String REQUIRED_RAW_MATERIAL = "Feather";

    public Weaver() {
        super(WEAVER_BUILD_COST, WEAVER_PRODUCE_TIME);
    }
}
