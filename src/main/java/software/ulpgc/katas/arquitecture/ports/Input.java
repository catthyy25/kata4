package software.ulpgc.katas.arquitecture.ports;

import java.lang.reflect.Parameter;

public interface Input {
    Parameter get(String name);

    interface Parameter {
        String asString();
        int asInteger();
    }
}
