public class Buffalo extends FarmAnimal {
    private static final String BUFFALO_PRODUCT = "Milk";
    private static final int BUFFALO_PRODUCING_TIME = 5;
    private static final int BUFFALO_PRICE = 400;

    public Buffalo() {
        super(BUFFALO_PRODUCT, BUFFALO_PRODUCING_TIME, BUFFALO_PRICE);
    }

    public static int getBuffaloPrice() {
        return BUFFALO_PRICE;
    }

    @Override
    public String getAnimalName() {
        return "Buffalo";
    }

}
