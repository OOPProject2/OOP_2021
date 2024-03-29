public class Tiger extends WildAnimal {
    public static final int TIGER_CAGE_LEVEL_REQUIRED = 4;
    public static final int TIGER_PRICE = 500;
    private static final int TIGER_MOVE_PER_TIME_UNIT = 2;
    public int lastMoveDirection;

    public Tiger() {
        super(TIGER_PRICE, TIGER_CAGE_LEVEL_REQUIRED, TIGER_MOVE_PER_TIME_UNIT);
    }

    @Override
    public String getAnimalName() {
        return "Tiger";
    }

    @Override
    protected void movement() {
        lastMoveDirection = super.movement(TIGER_MOVE_PER_TIME_UNIT);
    }
}
