public class Mill extends WorkShop{
    public static final int MILL_BUILD_COST = 150;
    public static final int MILL_PRODUCE_TIME = 4;
    private static final String PRODUCT = "Egg";
    private static final String REQUIRED_RAW_MATERIAL = "Flour";

    public Mill() {
        super(MILL_BUILD_COST, MILL_PRODUCE_TIME);
    }
}
