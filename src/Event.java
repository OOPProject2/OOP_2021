import java.io.FileWriter;
import java.util.ArrayList;

public class Event {
    private static int currentTime = 1;
    private int eventTime;
    private int eventCode;
    private boolean statue = false;//indicates if the events is already done or not ,true for done
    public static final int FILLING_BUCKET = 1;
    private static final ArrayList<Event> events = new ArrayList<>();

    public static void addEvent(int eventCode) {
        switch (eventCode) {
            case FILLING_BUCKET: {
                events.add(new Event(currentTime + Well.REFILLING_TIME, FILLING_BUCKET));
            }
        }
    }

    public void turnTime(int turnAmount) {
        currentTime += turnAmount;
        check();
    }

    private static void check() {
        for (Event event : events) {
            if (!event.statue) {
                if (event.eventTime >= currentTime) {
                    doEvent(event);
                }
            }
        }
    }

    private static void doEvent(Event event) {
        switch (event.eventCode) {
            case FILLING_BUCKET: {
                Well.fillingBucket();
                event.statue = true;
                Log.bucketFilled();
            }
        }
    }
    public Event(int eventTime, int eventCode) {
        this.eventTime = eventTime;
        this.eventCode = eventCode;
    }
}
