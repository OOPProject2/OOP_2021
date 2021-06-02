public class FarmAnimal extends Animal {
    private final String PRODUCED_PRODUCT;
    private final int TIME_PER_PRODUCT;
    private int life = 100;
    private static final int FARM_ANIMALS_MOVE_PER_TIME_UNIT = 1;

    public FarmAnimal(String PRODUCED_PRODUCT, int TIME_PER_PRODUCT, int price) {
        super(price, FARM_ANIMALS_MOVE_PER_TIME_UNIT);
        this.PRODUCED_PRODUCT = PRODUCED_PRODUCT;
        this.TIME_PER_PRODUCT = TIME_PER_PRODUCT;
    }
}
