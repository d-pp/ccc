package util;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class CCC {
    public static int currDir(String name) {
        return Arrays.stream(Objects.requireNonNull(new File(".").listFiles(File::isDirectory)))
                .map(File::getName)
                .filter(s -> s.contains(name))
                .map(s -> Integer.parseInt(s.split(name)[1]))
                .max(Comparator.naturalOrder())
                .orElseThrow();
    }
}
