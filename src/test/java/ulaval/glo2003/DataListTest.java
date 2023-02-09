package ulaval.glo2003;

import org.junit.jupiter.api.Test;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;

class DataListTest {

    private final Instant A_MOMENT = Instant.now();
    private final Instant BEFORE_A_MOMENT = A_MOMENT.minusSeconds(5);
    private final Instant AFTER_A_MOMENT = A_MOMENT.plusSeconds(5);

    @Test
    public void canAverageDataItemsCountBetweenTwoMoments() {
        DataItem item1 = new DataItem(A_MOMENT, "abc", 4);
        DataItem item2 = new DataItem(A_MOMENT, "def", 5);
        DataList dataList = new DataList(Arrays.asList(item1, item2));

        double averageCount = dataList.averageCountBetween(BEFORE_A_MOMENT, AFTER_A_MOMENT);

        assertThat(averageCount).isEqualTo(4.5);
    }

    @Test
    public void givenNoDataItems_averageCountShouldBeZero() {
        DataList dataList = new DataList(new ArrayList<>());

        double averageCount = dataList.averageCountBetween(BEFORE_A_MOMENT, AFTER_A_MOMENT);

        assertThat(averageCount).isEqualTo(0);
    }

    @Test
    public void givenDataItemsAtRangeLimit_whenAveragingCount_shouldCalculateFromTheseItems() {
        DataItem item1 = new DataItem(BEFORE_A_MOMENT, "abc", 4);
        DataItem item2 = new DataItem(AFTER_A_MOMENT, "def", 5);
        DataList dataList = new DataList(Arrays.asList(item1, item2));

        double averageCount = dataList.averageCountBetween(BEFORE_A_MOMENT, AFTER_A_MOMENT);

        assertThat(averageCount).isEqualTo(4.5);
    }

    @Test
    public void givenDataItemsOutsideOfRange_whenAveragingCount_shouldIgnoreOutOfRangeDate() {

    }
}
