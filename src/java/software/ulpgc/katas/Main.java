package software.ulpgc.katas;

import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class Main {
    static void main() {
        Javalin.create(c -> init(c)).start(8080);
    }

    private static void init(JavalinConfig config){
        config.routes.get("/hola/{name}", c -> hola(c));
        config.routes.get("/fibonacci", c -> fibonacci(c));
    }

    private static void hola(Context context) {
        String name = context.pathParam("name");
        context.result("Hola " + name);
    }

    private static void fibonacci(Context context) {
        context.result(fibonacci(context.queryParam("n")));
    }

    private static String fibonacci(String n) {
        return String.valueOf(fibonacci(Integer.parseInt(n)));
    }

    private static int fibonacci(int n) {
        int a = 0;
        int b = 1;
        for (int i = 0; i < n; i++){
            int c = a;
            a = b;
            b += c;
        }
        return a;
    }
}
