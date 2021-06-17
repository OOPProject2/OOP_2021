public class Chicken extends FarmAnimal {
    private static final String CHICKENS_PRODUCT = "Egg";
    private static final int CHICKENS_PRODUCING_TIME = 2;
    private static final int CHICKENS_PRICE = 100;

    public Chicken() {
        super(CHICKENS_PRODUCT, CHICKENS_PRODUCING_TIME, CHICKENS_PRICE);
    }

    public static int getChickensPrice() {
        return CHICKENS_PRICE;
    }

    @Override
    public String getAnimalName() {
        return "Chicken";
    }
}
