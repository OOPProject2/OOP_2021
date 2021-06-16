public class GameField {
    private static int[][]gameField = new int[6][6];

    public GameField() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                gameField[i][j] = 0;
            }
        }
    }
    public static boolean planting(int x, int y){
        if (x > 6 || x < 1 || y > 6 || y < 1){
            Log.planting(x,y,2);
            return false;
        } else{
            gameField[x-1][y-1]++;
            return true;
        }
    }
}
