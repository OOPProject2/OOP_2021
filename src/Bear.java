public class Bear extends WildAnimal {
    public static final int BEAR_CAGE_LEVEL_REQUIRED = 4;
    public static final int BEAR_PRICE = 400;
    private static final int BEAR_MOVE_PER_TIME_UNIT = 1;

    public Bear() {
        super(BEAR_PRICE, BEAR_CAGE_LEVEL_REQUIRED, BEAR_MOVE_PER_TIME_UNIT);
    }

    @Override
    public String getAnimalName() {
        return "Bear";
    }

    @Override
    protected void movement() {
        super.movement(BEAR_MOVE_PER_TIME_UNIT);
    }
}
