public class Tailor extends WorkShop{
    public static final int TAILOR_BUILD_COST = 400;
    public static final int TAILOR_PRODUCE_TIME = 6;
    private static final String PRODUCT = "Shirt";
    private static final String REQUIRED_RAW_MATERIAL = "Fabric";

    public Tailor() {
        super(TAILOR_BUILD_COST, TAILOR_PRODUCE_TIME);
    }
}
