import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Mission {
    private final String path = "Missions.txt";
    private static int Level;
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
        Level = level;
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
            Pattern pattern=Pattern.compile("\\w+");
            while (scanner.hasNext() && isStillCurrentLevel) {
                switch (scanner.next(pattern).toLowerCase(Locale.ROOT)) {
                    case "level": {
                        isStillCurrentLevel = false;
                        break;
                    }
                    case "bear": {
                        Event.addWildAnimalSpawnEvent(scanner.nextInt(), "bear");
                        break;
                    }
                    case "lion": {
                        Event.addWildAnimalSpawnEvent(scanner.nextInt(), "lion");
                        break;
                    }
                    case "tiger": {
                        Event.addWildAnimalSpawnEvent(scanner.nextInt(), "tiger");
                        break;
                    }
                    case "bread": {
                        Manager.addTask(new Task("bread", scanner.nextInt()));
                        break;
                    }
                    case "egg": {
                        Manager.addTask(new Task("egg", scanner.nextInt()));
                        break;
                    }
                    case "fabric": {
                        Manager.addTask(new Task("fabric", scanner.nextInt()));
                        break;
                    }
                    case "feather": {
                        Manager.addTask(new Task("feather", scanner.nextInt()));
                        break;
                    }
                    case "flour": {
                        Manager.addTask(new Task("flour", scanner.nextInt()));
                        break;
                    }
                    case "ice" + "cream": {
                        Manager.addTask(new Task("ice" + "cream", scanner.nextInt()));
                        break;
                    }
                    case "milk": {
                        Manager.addTask(new Task("milk", scanner.nextInt()));
                        break;
                    }
                    case "packed" + "milk": {
                        Manager.addTask(new Task("packed" + "milk", scanner.nextInt()));
                        break;
                    }
                    case "shirt": {
                        Manager.addTask(new Task("shirt", scanner.nextInt()));
                        break;
                    }
                    default:{
                        break;
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

