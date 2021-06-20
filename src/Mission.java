import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

//for try to update
public class Mission {
    private int level;
    Scanner input = new Scanner(System.in);
    String path = input.next();
    File file = new File("C:\\Users\\ahmadzade\\project\\missionReader");

    public boolean checkFile(File file) {
        if (!file.exists()) {
            System.out.println("file path you entered does not exist");
            return false;
        } else if (!file.canRead()) {
            System.out.println("file path you entered can not read");
            return false;
        }
        return true;
    }

    public void recieve(File file) throws FileNotFoundException {
        if (checkFile(file)) {
            Scanner sc = new Scanner(file);
            String level = null;
            while ((sc.hasNextLine())) {
                level = sc.nextLine();
                if (level.startsWith("1")) {
                    processLevel1(level.split("\\s"));
                } else if (level.startsWith("2")) {
                    processLevel2(level.split("\\s"));
                } else if (level.startsWith("3")) {
                    processLevel3(level.split("\\s"));
                } else if (level.startsWith("4")) {
                    processLevel4(level.split("\\s"));
                } else if (level.startsWith("5")) {
                    processLevel5(level.split("\\s"));
                } else
                    System.out.println("Invalid input for level");
                sc.close();
            }
        }
    }

    private void processLevel5(String[] split) {

    }

    private void processLevel4(String[] split) {

    }

    private void processLevel3(String[] split) {
    }

    private void processLevel2(String[] split) {
    }

    private void processLevel1(String[] split) {

    }
}

//read  files in project has exist in directory

