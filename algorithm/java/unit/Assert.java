package unit;

import java.util.Objects;

public final class Assert {

    public static void assertEquals(Object a, Object b) {
        if (!Objects.equals(a, b)) {
            throw new RuntimeException("not equals");
        }
    }
}