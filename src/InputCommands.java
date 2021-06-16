import java.util.regex.Matcher;
import java.util.regex.Pattern;

public enum InputCommands {
    SIGNUP("(?i)\\s*signup\\s*"),
    LOGIN("(?i)\\s*log\\s*in\\s*"),
    USERNAME("(?i)\\s*username\\s+(\\S+)\\s*"),
    PASSWORD("(?i)\\s*password\\s+(\\S+)\\s*"),
    EXIT("(?i)\\s*exit\\s*"),
    START("(?i)\\s*start\\s+(\\d+)\\s*"),
    LOGOUT("(?i)\\s*log\\s*out\\s*"),
    SETTINGS("(?i)\\s*settings\\s*"),
    BUY("(?i)\\s*buy\\s+(\\w+)\\s*"),
    PICKUP("(?i)\\s*pickup\\s+([1-6])\\s+([1-6])\\s*"),
    WELL("(?i)\\s*well\\s*"),
    PLANT("(?i)\\s*plant\\s+([1-6])\\s+([1-6])\\s*"),
    BUILD("(?i)\\s*work\\s+(\\w+)\\s*"),
    WORK("(?i)\\s*work\\s+(\\w+)\\s*"),
    CAGE("(?i)\\s*cage\\s+([1-6])\\s+([1-6])\\s*"),
    TURN("(?i)\\s*turn\\s+(\\d+)\\s*"),
    TRUCK_LOAD("(?i)\\s*truck\\s+load\\s+(\\w+)\\s*"),
    TRUCK_UNLOAD("(?i)\\s*truck\\s+unload\\s+(\\w+)\\s*"),
    TRUCK_GO("(?i)\\s*truck\\s+go\\s*"),
    MENU("(?i)\\s*menu\\s*"),
    USER("User{username='(\\S+)', password='(\\S+)', missionsPassed=(\\d+), coinsForNextMission=(\\d+)}");

    Pattern pattern;
    InputCommands(String regex) {
        pattern=Pattern.compile(regex);
    }
    public Matcher getMatcher(String input) {
        return this.pattern.matcher(input);
    }
}
