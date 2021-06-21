import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

public class Mission {
    private final String path = "Missions.txt";
    private static int level;
    private static int initialCoins;
    private static int timeToGetPrize;
    private static int prize;
    private static FileReader fileReader;

    public Mission() {
        try {
            fileReader = new FileReader(path);
        } catch (IOException e) {
            System.out.println("ERROR : reading from File");
            e.printStackTrace();
        }
    }

    public static void Level(int level) {
        level = level;
        try {
            Scanner scanner = new Scanner(fileReader);
            boolean levelFound = false;
            while (scanner.hasNext() && !levelFound) {
                if (scanner.next().equalsIgnoreCase("level"))
                    if (scanner.next().equalsIgnoreCase(String.valueOf(level))) {
                        levelFound = true;
                    }
            }
            initialCoins = scanner.nextInt();
            timeToGetPrize = scanner.nextInt();
            prize = scanner.nextInt();
            boolean isStillCurrentLevel = true;
            while (scanner.hasNext() && isStillCurrentLevel) {
                switch (scanner.next().toLowerCase(Locale.ROOT)) {
                    case "level": {
                        isStillCurrentLevel = false;
                        break;
                    }
                    case "bear": {
                        Event.addWildAnimalSpawnEvent(scanner.nextInt(), "bear");
                    }
                    case "lion": {
                        Event.addWildAnimalSpawnEvent(scanner.nextInt(), "lion");
                    }
                    case "tiger": {
                        Event.addWildAnimalSpawnEvent(scanner.nextInt(), "tiger");
                    }
                    case "bread": {
                        Manager.addTask(new Task("bread", scanner.nextInt()));
                    }
                    case "egg": {
                        Manager.addTask(new Task("egg", scanner.nextInt()));
                    }
                    case "fabric": {
                        Manager.addTask(new Task("fabric", scanner.nextInt()));
                    }
                    case "feather": {
                        Manager.addTask(new Task("feather", scanner.nextInt()));
                    }
                    case "flour": {
                        Manager.addTask(new Task("flour", scanner.nextInt()));
                    }
                    case "ice" + "cream": {
                        Manager.addTask(new Task("ice" + "cream", scanner.nextInt()));
                    }
                    case "milk": {
                        Manager.addTask(new Task("milk", scanner.nextInt()));
                    }
                    case "packed" + "milk": {
                        Manager.addTask(new Task("packed" + "milk", scanner.nextInt()));
                    }
                    case "shirt": {
                        Manager.addTask(new Task("shirt", scanner.nextInt()));
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("ERROR :Reading FRom File");
            e.printStackTrace();
        }
    }

    public static int getInitialCoins() {
        return initialCoins;
    }

    public static int getTimeToGetPrize() {
        return timeToGetPrize;
    }

    public static int getPrize() {
        return prize;
    }
}

//read  files in project has exist in directory

