public class Feather extends Product{
    private static final int FEATHER_PRICE = 20;
    private static final int REQUIRED_SPACE = 1;
    private static final int TIME_UNIT_TO_GET = 4;
    public Feather() {
        super(FEATHER_PRICE, REQUIRED_SPACE, TIME_UNIT_TO_GET);
    }

    @Override
    public String getName() {
        return "Feather";
    }
}
