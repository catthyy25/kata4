package software.ulpgc.katas;

import io.javalin.Javalin;
import io.javalin.config.JavalinConfig;

public class Main {
    static void main() {
        Javalin.create(c -> init(c)).start(8080);
    }

    private static void init(JavalinConfig config){
        config.routes.get("/hola", c -> c.result("Hola mundo"));
        config.routes.get("/adios", c -> c.result("Adios mundo"));
    }
}
