package build;

import java.util.List;

public class searchPair {
    public final List<Integer> indices;
    public final int count;

    public searchPair(List<Integer> indices, int count) {
        this.indices = indices;
        this.count = count;
    }

    public List<Integer> getIndices() {
        return indices;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "Indices: " + indices.toString();
    }
}
