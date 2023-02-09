package ulaval.glo2003;

import java.time.Instant;

public class DataItem {
    private final Instant timestamp;
    private final String id;
    private final int count;

    public DataItem(Instant timestamp, String id, int count) {
        this.timestamp = timestamp;
        this.id = id;
        this.count = count;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public String getId() {
        return id;
    }

    public int getCount() {
        return count;
    }
}
