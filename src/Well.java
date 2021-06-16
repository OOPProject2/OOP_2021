public class Well {
    public static final int MAX_GRASS = 5;
    private static final int REFILLING_TIME = 3;
    private static int currentLevel = 5;

    public static void planting(int x, int y) {
        if (currentLevel < 1) {
            System.out.println("not enough water in the well");
            Log.planting(x,y,1);
        } else {
            if (GameField.planting(x, y))
                currentLevel--;
        }
    }
}
