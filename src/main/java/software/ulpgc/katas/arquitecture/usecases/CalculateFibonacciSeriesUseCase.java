package software.ulpgc.katas.arquitecture.usecases;

import software.ulpgc.katas.arquitecture.domain.Series;
import software.ulpgc.katas.arquitecture.ports.Input;
import software.ulpgc.katas.arquitecture.ports.Output;
import software.ulpgc.katas.arquitecture.ports.SeriesSerializer;

public class CalculateFibonacciSeriesUseCase {
    private final SeriesSerializer serializer;

    public CalculateFibonacciSeriesUseCase(SeriesSerializer serializer) {
        this.serializer = serializer;
    }

    public Output execute(Input input) {
        Series series = calculate(input.get("n").asInteger());
        return () -> serializer.serialize(series);
    }

    private Series calculate(int n){
        Series series = new Series();
        int[] values = new int[n];
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            series = series.put(a);
            int c = a;
            a = b;
            b += series.last();
        }
        return series;
    }

    public SeriesSerializer serializer() {
        return serializer;
    }
}
