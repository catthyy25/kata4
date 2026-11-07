package software.ulpgc.katas;

import com.google.gson.Gson;
import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;
import software.ulpgc.katas.arquitecture.ports.Input;
import software.ulpgc.katas.arquitecture.ports.Output;
import software.ulpgc.katas.arquitecture.usecases.CalculateFibonacciSeriesUseCase;
import software.ulpgc.katas.infrastructure.adapters.ContextInput;
import software.ulpgc.katas.infrastructure.adapters.GsonSeriesSerializer;

public class Main {
    static void main() {
        Javalin.create(c -> init(c)).start(8080);
    }

    private static void init(JavalinConfig config){
        config.routes.get("/fibonacci", c -> fibonacci(c));
    }

    private static void fibonacci(Context context) {
        Input input = new ContextInput(context);
        Output output = new CalculateFibonacciSeriesUseCase(new GsonSeriesSerializer()).execute(input);
        context.result(output.result());
    }
}
