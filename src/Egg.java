public class Egg extends Product{
    private static final int EGG_PRICE = 15;
    private static final int REQUIRED_SPACE = 1;
    private static final int TIME_UNIT_TO_GET = 4;
    public Egg() {
        super(EGG_PRICE, REQUIRED_SPACE, TIME_UNIT_TO_GET);
    }

    @Override
    public String getName() {
        return "Egg";
    }
}
