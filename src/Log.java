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
            LOG.write("[INFO], player name : " + Manager.getPlayerName()  + getTime() + "\n");
            LOG.flush();
        }
        catch (IOException e){
            System.out.println("ERROR : Creating Log File");
            e.printStackTrace();
        }
    }

    public static void buyAnimalLog(String animalName,boolean condition){
            try {
                if (condition)
                LOG.write("INFO : " + "animal buy, " + "name : " + animalName + "status : successful" + getTime() );
                else
                    LOG.write("ALERT : " + "animal buy, " + "name : " + animalName + "status : unsuccessful" + getTime() );
            }
            catch (IOException e){
                System.out.println("ERROR : Writing to Log File");
                e.printStackTrace();
            }
    }

    private static String getTime(){
        return " ~Time : " + Calendar.getInstance().getTime();
    }
}
