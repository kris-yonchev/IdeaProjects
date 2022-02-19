package Generics.ListUtils;

import java.util.Collections;
import java.util.List;

public class ListUtils {
    public static <T extends Comparable<T>> T getMin(List<T> list) {
        isNotEmpty(list);
        return Collections.min(list);
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        isNotEmpty(list);
        return Collections.max(list);
    }

    private static <T> void isNotEmpty(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException("List is empty!");
        }
    }

}
