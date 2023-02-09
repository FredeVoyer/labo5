package ulaval.glo2003;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

public class DataList {
    private final List<DataItem> items;

    public DataList(List<DataItem> items) {
        this.items = items;
    }

    public double averageCountBetween(Instant start, Instant end) {
        List<DataItem> filtered = items.stream()
                .filter(item -> item.getTimestamp().isBefore(end) && item.getTimestamp().isAfter(start))
                .collect(Collectors.toList());

        if (filtered.isEmpty()) {
            return 0;
        }

        int sum = filtered.stream()
                .map(DataItem::getCount)
                .reduce(Integer::sum)
                .orElse(0);

        return (double)sum / (double)filtered.size();
    }
}
