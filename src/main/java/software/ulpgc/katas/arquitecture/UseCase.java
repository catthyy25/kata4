package software.ulpgc.katas.arquitecture;

import software.ulpgc.katas.arquitecture.ports.Input;
import software.ulpgc.katas.arquitecture.ports.Output;

public interface UseCase {
    Output execute(Input input);
}
