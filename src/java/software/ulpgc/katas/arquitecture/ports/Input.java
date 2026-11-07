package software.ulpgc.katas.arquitecture.ports;

public interface Input {

    Parameter get(String name);

    interface Parameter {
        String asString();
        int asInteger();
    }
}
