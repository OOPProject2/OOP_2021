public class Lion extends WildAnimal {
    public static final int LION_CAGE_LEVEL_REQUIRED = 3;
    public static final int LION_PRICE = 300;
    private static final int LION_MOVE_PER_TIME_UNIT = 1;

    public Lion() {
        super(LION_PRICE, LION_CAGE_LEVEL_REQUIRED, LION_MOVE_PER_TIME_UNIT);
    }

    @Override
    public String getAnimalName() {
        return "Lion";
    }

    @Override
    protected void movement() {
        super.movement(LION_MOVE_PER_TIME_UNIT);
    }
}
