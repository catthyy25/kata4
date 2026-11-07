package software.ulpgc.katas.arquitecture.usecases;

import com.google.gson.Gson;
import software.ulpgc.katas.arquitecture.ports.Input;
import software.ulpgc.katas.arquitecture.ports.Output;

public class CalculateFibonacciSeriesUseCase {
    public Output execute(Input input) {
        int[] values = calculate(input.get("n").asInteger());
        return () -> new Gson().toJson(values);   // MAL
    }

    private int[] calculate(int n) {
        int[] values = new int[n];
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++) {
            values[i] = a;
            int c = a;
            a = b;
            b += c;
        }
        return values;
    }
}
