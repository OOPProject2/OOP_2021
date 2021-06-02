public class Turkey extends FarmAnimal {
    private static final String TURKEY_PRODUCT = "Feather";
    private static final int TURKEY_PRODUCING_TIME = 3;
    private static final int TURKEY_PRICE = 200;

    public Turkey() {
        super(TURKEY_PRODUCT, TURKEY_PRODUCING_TIME, TURKEY_PRICE);
    }

    public static int getTurkeyPrice() {
        return TURKEY_PRICE;
    }
}
