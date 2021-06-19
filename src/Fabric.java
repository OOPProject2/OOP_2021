public class Fabric extends Product{
    private static final int FABRIC_PRICE = 50;
    private static final int REQUIRED_SPACE = 2;
    private static final int TIME_UNIT_TO_GET = 5;
    public Fabric() {
        super(FABRIC_PRICE, REQUIRED_SPACE, TIME_UNIT_TO_GET);
    }

    @Override
    public String getName() {
        return "Fabric";
    }
}