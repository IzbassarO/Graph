import java.util.HashMap;
import java.util.Map;

public class Vertex<V> {
    private final V data;
    private final Map<Vertex<V>, Double> adjVertices = new HashMap<>();

    public Vertex(V data) {
        this.data = data;
    }

    public void addAdjVertex(Vertex<V> dest, double weight) {
        adjVertices.put(dest,weight);
    }

    public V getData() {
        return data;
    }
    public Map<Vertex<V>, Double> getAdjVertices() {
        return adjVertices;
    }

}
