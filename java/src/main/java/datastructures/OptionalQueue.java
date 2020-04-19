package datastructures;

import java.util.Optional;

public class OptionalQueue<T> extends Queue<T> {

    /**
     * Remove from Head
     *
     * @return Optional
     */
    public Optional<T> safeRemove() {
        return Optional.ofNullable(super.remove());
    }
}
