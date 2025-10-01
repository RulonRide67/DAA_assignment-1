package algorithms;

import org.junit.jupiter.api.Test;
import java.util.Arrays;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class SelectTest {

    @Test
    public void testSmallArrays() {
        int[] arr = {7, 2, 1, 6, 8, 5, 3, 4};
        Arrays.sort(arr.clone()); // контроль
        assertEquals(1, Select.select(arr.clone(), 0)); // минимум
        assertEquals(8, Select.select(arr.clone(), arr.length - 1)); // максимум
    }

    @Test
    public void testRandomArrays() {
        Random random = new Random();
        for (int n = 10; n <= 100; n += 10) {
            int[] arr = random.ints(n, 0, 1000).toArray();
            int[] sorted = arr.clone();
            Arrays.sort(sorted);

            for (int k = 0; k < n; k++) {
                assertEquals(sorted[k], Select.select(arr.clone(), k));
            }
        }
    }

    @Test
    public void testSingleElement() {
        int[] arr = {42};
        assertEquals(42, Select.select(arr, 0));
    }

    @Test
    public void testInvalidInput() {
        assertThrows(IllegalArgumentException.class, () -> Select.select(new int[]{}, 0));
        assertThrows(IllegalArgumentException.class, () -> Select.select(new int[]{1, 2, 3}, -1));
        assertThrows(IllegalArgumentException.class, () -> Select.select(new int[]{1, 2, 3}, 3));
    }
}
