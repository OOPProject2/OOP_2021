import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;

public class User {
    private final String username;
    private final String password;
    private int missionsPassed;
    private int coinsForNextMission;

    public User(String username, String password, int missionsPassed, int coinsForNextMission) {
        this.username = username;
        this.password = password;
        this.missionsPassed = missionsPassed;
        this.coinsForNextMission = coinsForNextMission;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getMissionsPassed() {
        return missionsPassed;
    }

    public int getCoinsForNextMission() {
        return coinsForNextMission;
    }

    public void setMissionsPassed(int missionsPassed) {
        this.missionsPassed = missionsPassed;
    }

    public void setCoinsForNextMission(int coinsForNextMission) {
        this.coinsForNextMission = coinsForNextMission;
    }


    public void appendToFile(File userFile){
        try {
            FileWriter fw =new FileWriter(userFile,true);
            BufferedWriter bw=new BufferedWriter(fw);
            fw.append(toString());
            bw.close();
            fw.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void readUsers(File userFile, ArrayList<User> users){
        try {
            FileReader fr =new FileReader(userFile);
            BufferedReader br=new BufferedReader(fr);
            String input;
            Matcher matcher;
            while ( (input=br.readLine())!=null){
                matcher=InputCommands.USER.getMatcher(input);
                if(matcher.matches()){
                    users.add(new User(matcher.group(1),matcher.group(2),Integer.parseInt(matcher.group(3)),Integer.parseInt(matcher.group(4))));
                }
            }
            br.close();
            fr.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", missionsPassed=" + missionsPassed +
                ", coinsForNextMission=" + coinsForNextMission +
                "}\n";
    }
}
