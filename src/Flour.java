public class Flour extends Product{
    private static final int FLOUR_PRICE = 40;
    private static final int REQUIRED_SPACE = 2;
    private static final int TIME_UNIT_TO_GET = 5;
    public Flour() {
        super(FLOUR_PRICE, REQUIRED_SPACE, TIME_UNIT_TO_GET);
    }

    @Override
    public String getName() {
        return "Flour";
    }
}
