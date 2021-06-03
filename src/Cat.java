public class Cat extends OtherAnimals{
    private static final int CAT_PRICE = 150;

    public Cat() {
        super(CAT_PRICE);
    }

    public static int getCatPrice() {
        return CAT_PRICE;
    }
}
