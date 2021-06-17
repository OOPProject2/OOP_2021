public class WildAnimal extends Animal {
    private final int CAGE_LEVEL_REQUIRED;
    private static final int TIME_UNIT_TO_ESCAPE = 5;
    private int currentTimeUnitToEscape;
    private int currentLevel;

    public WildAnimal(int price, int CAGE_LEVEL_REQUIRED, int movePerTimeUnit) {
        super(price, movePerTimeUnit);
        this.CAGE_LEVEL_REQUIRED = CAGE_LEVEL_REQUIRED;
        this.currentLevel = 0;
    }

    @Override
    public void showAnimal() {
        System.out.print(getAnimalName() + " " + (CAGE_LEVEL_REQUIRED - currentLevel) + " ");
        super.showAnimal();
    }

    @Override
    public String getAnimalName() {
        return super.getAnimalName();
    }
}
