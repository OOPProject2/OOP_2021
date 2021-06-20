public class WildAnimal extends Animal {
    private final int CAGE_LEVEL_REQUIRED;
    private static final int TIME_UNIT_TO_ESCAPE = 5;
    private int currentTimeUnitToEscape;
    private int currentLevel;
    private static final int SPACE_REQUIRED = 15;

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

    public static int getSpaceRequired() {
        return SPACE_REQUIRED;
    }

    public void cage() {
        if (!isFullyCaged()) {
            currentLevel++;
            Log.cage(this.getAnimalName(), this.getXLoc(), this.getYLoc(), 1);
            System.out.println("animal cage level increased successfully");
        } else {
            System.out.println("animal is in max cage level");
            Log.cage(this.getAnimalName(), this.getXLoc(), this.getYLoc(), 2);
        }
    }

    public void store() {
        this.setXLoc(0);
        this.setYLoc(0);
    }

    public boolean isFullyCaged() {
        return currentLevel == CAGE_LEVEL_REQUIRED;
    }
}
