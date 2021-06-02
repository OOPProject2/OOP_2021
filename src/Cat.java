public class Cat extends Animal{
    private static final int CAT_PRICE = 150;
    private static final int CAT_MOVE_PER_TIME_UNIT = 1;

    public Cat() {
        super(CAT_PRICE, CAT_MOVE_PER_TIME_UNIT);
    }

    public static int getCatPrice() {
        return CAT_PRICE;
    }
}
