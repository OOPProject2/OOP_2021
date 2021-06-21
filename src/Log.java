import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;

public class Log {
    private static FileWriter LOG;
    private static Manager manager;

    public Log(Manager manager) {
        Log.manager = manager;
        try {
            LOG = new FileWriter("log.txt");
            LOG.write("[INFO], player name : " + Manager.getPlayerName() + getTime() + "\n");
            LOG.flush();
        } catch (IOException e) {
            System.out.println("ERROR : Creating Log File");
            e.printStackTrace();
        }
    }

    public static void buyAnimalLog(String animalName, boolean condition, String reason) {
        try {
            if (condition)
                LOG.write("INFO : " + "animal buy, " + "name : " + animalName + "status : successful" + getTime());
            else
                LOG.write("ALERT : " + "animal buy, " + "name : " + animalName + "status : unsuccessful reason : "
                        + reason + getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void planting(int x, int y, int reasonCode) {
        try {
            switch (reasonCode) {
                case 1: {
                    LOG.write("ALERT : planting attempt unsuccessful!!! reason : not enough water" + getTime());
                }
                case 2: {
                    LOG.write("ALERT : planting attempt unsuccessful!!! reason : incorrect coordinates" + getTime());
                }
                case 3: {
                    LOG.write("ALERT : planting attempt successful at coordinates " + x + " " + y + getTime());
                }
                default: {
                    LOG.write("ALERT : planting attempt");
                }
            }
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void fillingBucket(boolean statue) {
        try {
            if (statue)
                LOG.write("INFO : filling bucket attempt successful" + getTime());
            else
                LOG.write("ALERT : filling bucket attempt unsuccessful reason : bucket still has water" + getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void bucketFilled() {
        try {
            LOG.write("INFO : bucket filled successful" + getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void animalMove(String animalName, int oldX, int oldY, int newX, int newY) {
        try {
            LOG.write("INFO : animal " + animalName + "moved from (" + oldX + "," + oldY + ")to (" +
                    newX + "," + newY + ")" + getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void turnTime(int timeUnit) {
        try {
            LOG.write("INFO : time turned bu amount " + timeUnit + getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void pickup(String name, int x, int y, boolean statue) {
        try {
            if (statue) {
                LOG.write("INFO : " + name + " picked up at coordinates (" + x + "," + y + ")" + getTime());
            } else
                LOG.write("INFO : pickingUp attempt unsuccessful at coordinates(" + x + "," + y + ") " +
                        "reason : nothing to pickup" + getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void moveToWareHouse(String name, int statue) {
        try {
            if (statue == 1)
                LOG.write("INFO : " + name + " moved to warehouse successfully" + getTime());
            else if (statue == 2)
                LOG.write("ALERT  : move to warehouse attempt unsuccessful: " + name + " cannot be moved " +
                        "to warehouse reason : not enough space" + getTime());
            else if (statue == 3)
                LOG.write("ALERT : move to warehouse attempt unsuccessful: " + name + " cannot be moved " +
                        "to warehouse reason : wild animal is not in max cage level" + getTime());

        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void cage(String animalName, int x, int y, int statue) {
        try {
            if (statue == 1)
                LOG.write("INFO : attempt to cage a " + animalName + "at coordinates(" + x + "," + y + ")"
                        + " successful" + getTime());
            else if (statue == 2)
                LOG.write("INFO : attempt to cage a " + animalName + "at coordinates(" + x + "," + y + ")"
                        + "unsuccessful reason : animal is already in max level of cage" + getTime());
            else if (statue == 3)
                LOG.write("INFO : attempt to cage a wildAnimal at coordinates(" + x + "," + y + ")"
                        + "unsuccessful reason : animal not found" + getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void Build(String workShopName, int statue) {
        try {
            if (statue == 1)
                LOG.write("INFO : attempt to build " + workShopName + " unsuccessful reason : workshop already exist"
                        + getTime());
            else if (statue == 2)
                LOG.write("INFO : attempt to build " + workShopName + " unsuccessful reason : not enough coins"
                        + getTime());
            else if (statue == 3)
                LOG.write("INFO : attempt to build " + workShopName + " unsuccessful reason : workshop not found"
                        + getTime());
            else if (statue == 4)
                LOG.write("INFO : attempt to build " + workShopName + " successful" + getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void loadToTruck(String name, int statue) {
        try {
            if (statue == 1)
                LOG.write("INFO : " + name + " loaded to truck successfully" + getTime());
            else if (statue == 2)
                LOG.write("ALERT  : load to truck attempt unsuccessful: " + name + " cannot be loaded " +
                        "to truck reason : not enough space" + getTime());
            else if (statue == 3)
                LOG.write("ALERT  : load to truck attempt unsuccessful: " + name + " cannot be loaded " +
                        "to truck reason : truck is busy" + getTime());

        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void unloadFromTruck(String name, int statue) {
        try {
            if (statue == 1)
                LOG.write("INFO : " + name + " unloaded from truck successfully" + getTime());
            else if (statue == 2)
                LOG.write("ALERT  : unload from truck attempt unsuccessful: " + name + " cannot be unloaded " +
                        "from truck reason : not enough space" + getTime());
            else if (statue == 3)
                LOG.write("ALERT  : unload from truck attempt unsuccessful: " + name + " cannot be unloaded " +
                        "from truck reason : item not found" + getTime());
            else if (statue == 4)
                LOG.write("ALERT  : unload from truck attempt unsuccessful: " + name + " cannot be unloaded " +
                        "from truck reason : truck is busy" + getTime());

        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void truckGo(int statue) {
        try {
            if (statue == 1)
                LOG.write("INFO : " + "truck started successfully" + getTime());
            else if (statue == 2)
                LOG.write("ALERT  : truck start attempt unsuccessful: reason : truck already in work" + getTime());
            else if (statue == 3)
                LOG.write("ALERT  : truck returned successfully" + getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void addCoins(int amount) {
        try {
            LOG.write("INFO : " + amount + " coins added" + getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void work(String workshopName, int statue) {
        try {
            if (statue == 1)
                LOG.write("INFO : " + workshopName + " start working attempt unsuccessful reason : " +
                        "workshop doesnt exit or not built yet" + getTime());
            else if (statue == 2)
                LOG.write("INFO  : " + workshopName + " started working" + getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void addProduct(String productName) {
        try {
            LOG.write("INFo : " + productName + " added to game" + getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    public static void disappearProduct(String productName) {
        try {
            LOG.write("INFo : " + productName + " disappeared from game because it didnt were collected on time" +
                    getTime());
        } catch (IOException e) {
            System.out.println("ERROR : Writing to Log File");
            e.printStackTrace();
        }
    }

    private static String getTime() {
        return " ~Time : " + Calendar.getInstance().getTime();
    }
}
