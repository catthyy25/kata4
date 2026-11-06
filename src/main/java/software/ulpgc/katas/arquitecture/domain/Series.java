package software.ulpgc.katas.arquitecture.domain;

import java.util.Arrays;

public record Series(int[] values) {
    public Series() {
        this(new int[0]);
    }

    public Series put(int n) {
        int[] newValues = Arrays.copyOf(values, values.length + 1);
        newValues[values.length] = n;
        return new Series(newValues);
    }
    public int last() {
        return values[values.length - 1];
    }
}
