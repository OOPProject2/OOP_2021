public class Cat extends OtherAnimals {
    private static final int CAT_PRICE = 150;

    public Cat() {
        super(CAT_PRICE);
    }

    public static int getCatPrice() {
        return CAT_PRICE;
    }

    @Override
    public String getAnimalName() {
        return "Cat";
    }

    @Override
    protected void movement() {
        char movementDirection = Manager.closestProduct(getXLoc(), getXLoc());
        switch (movementDirection) {
            case 'N' -> {
                move('N', MOVE_PER_TIME_UNIT);
            }
            case 'E' -> {
                move('E', MOVE_PER_TIME_UNIT);
            }
            case 'W' -> {
                move('W', MOVE_PER_TIME_UNIT);
            }
            case 'S' -> {
                move('S', MOVE_PER_TIME_UNIT);
            }
            case 'O' -> {
            }
        }
    }
}
