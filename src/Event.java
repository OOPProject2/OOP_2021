import java.io.FileWriter;
import java.util.ArrayList;

public class Event {
    private static int currentTime = 1;
    private int eventTime;
    private int eventCode;
    private boolean statue = false;//indicates if the events is already done or not ,true for done
    public static final int FILLING_BUCKET = 1;
    public static final int TRUCK_GO = 2;
    private static final ArrayList<Event> events = new ArrayList<>();

    public static void addEvent(int eventCode) {
        switch (eventCode) {
            case FILLING_BUCKET: {
                events.add(new Event(currentTime + Well.REFILLING_TIME, FILLING_BUCKET));
            }
            case TRUCK_GO: {
                events.add(new Event(currentTime + Truck.TIME_UNIT_TO_WORK, TRUCK_GO));
            }
        }
    }

    public static void turnTime(int turnAmount) {
        Log.turnTime(turnAmount);
        while (turnAmount > 0) {
            currentTime++;
            check();
            turnAmount--;
        }

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
            case TRUCK_GO: {
                Log.truckGo(3);
                event.statue = true;
                Truck.returned();
            }
        }
    }

    public Event(int eventTime, int eventCode) {
        this.eventTime = eventTime;
        this.eventCode = eventCode;
    }

    public static int getCurrentTime() {
        return currentTime;
    }
}
