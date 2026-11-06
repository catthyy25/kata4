package software.ulpgc.katas;

import com.google.gson.Gson;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;

import io.javalin.http.Context;
import software.ulpgc.katas.arquitecture.ports.Input;
import software.ulpgc.katas.arquitecture.ports.Output;
import software.ulpgc.katas.arquitecture.usecases.CalculateFibonacciSeriesUseCase;
import software.ulpgc.katas.infrastructure.adapters.ContextInput;

public class Main {
    static void main() {
        Javalin.create(c -> init(c)).start(8080);
    }

    private static void init(JavalinConfig config){
        config.routes.get("/fibonacci", c -> fibonacci(c));
    }

    private static void fibonacci(Context context){
        Input input = new ContextInput(context);
        Output output = new CalculateFibonacciSeriesUseCase().execute(input);
        context.result(output.result());
    }

    private static int[] fibonacci(int n){
        int[] values = new int[n];
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++){
            values[i] = a;
            int c = a;
            a = b;
            b += c;
        }
        return values;
    }
}
