public class IceCreamShop extends WorkShop {
    public static final int ICE_CREAM_SHOP_BUILD_COST = 550;
    public static final int ICE_CREAM_SHOP_PRODUCE_TIME = 7;
    private static final String PRODUCT = "IceCream";
    private static final String REQUIRED_RAW_MATERIAL = "PackedMilk";

    public IceCreamShop() {
        super(ICE_CREAM_SHOP_BUILD_COST, ICE_CREAM_SHOP_PRODUCE_TIME);
    }

    @Override
    public String getWorkShopName() {
        return "IceCreamShop";
    }
}
