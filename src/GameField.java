public class GameField {
    private static int[][]gameField = new int[6][6];

    public GameField() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                gameField[i][j] = 0;
            }
        }
    }
}
