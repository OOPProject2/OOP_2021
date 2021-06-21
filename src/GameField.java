public class GameField {
    private static int[][] gameField = new int[6][6];

    public GameField() {
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                gameField[i][j] = 0;
            }
        }
    }

    public static boolean planting(int x, int y) {
        if (x > 6 || x < 1 || y > 6 || y < 1) {
            System.out.println("incorrect coordinates");
            Log.planting(x, y, 2);
            return false;
        } else {
            gameField[x - 1][y - 1]++;
            return true;
        }
    }

    public static void showGameField() {
        System.out.println("Game Field");
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                System.out.print(gameField[i][j] + "  ");
            }
            System.out.println();
        }
    }

    public static char closestGrass(int x, int y) {
        double distance = 10000;
        int closestGrassX = x;
        int closestGrassY = y;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (gameField[i - 1][j - 1] != 0) {
                    int dist = (x - i) * (x - i) + (y - j) * (y - j);
                    if (dist < distance * distance) {
                        distance = Math.sqrt(dist);
                        closestGrassX = i;
                        closestGrassY = j;
                    }
                }
            }
        }
        if (Math.abs(x - closestGrassX) == 0 && Math.abs(y - closestGrassY) == 0)
            return 'O';
        else if (Math.abs(x - closestGrassX) > Math.abs(y - closestGrassY)) {
            if (x < closestGrassX)
                return 'E';
            if (x > closestGrassX)
                return 'W';
        } else if (Math.abs(x - closestGrassX) < Math.abs(y - closestGrassY)) {
            if (y < closestGrassY)
                return 'S';
            if (y > closestGrassY)
                return 'N';
        }
        return 'O';
    }

    public static int getGrassCount(int x, int y){
        return gameField[x-1][y-1];
    }

    public static void eatGrass(int x, int y){
        gameField[x-1][y-1]--;
    }
}
