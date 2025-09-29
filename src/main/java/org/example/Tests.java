package org.example;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;

public class Tests {
}

class SortTest {
    @Test
    void testSimpleSort() {
        int[] arr = {3, 1, 2};
        Arrays.sort(arr);
        assertArrayEquals(new int[]{1, 2, 3}, arr);
    }
}

