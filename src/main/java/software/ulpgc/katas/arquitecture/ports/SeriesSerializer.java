package software.ulpgc.katas.arquitecture.ports;

import software.ulpgc.katas.arquitecture.domain.Series;

public interface SeriesSerializer {
    String serialize(Series series);
}
