import java.util.*;

public class WeightedGraph<V> {
    private final boolean undirected;
    private Map<V, Vertex<V>> map = new HashMap<>();

    public WeightedGraph() {
        this.undirected = true;
    }

    public WeightedGraph(boolean undirected) {
        this.undirected = undirected;
    }

    public void addVertex(V v) {
        if (!hasVertex(v)) map.put(v,new Vertex<>(v));
    }

    public void addEdge(V source, V dest, double weight) {
        if (!hasVertex(source)) addVertex(source);
        if (!hasVertex(dest)) addVertex(dest);
        if (hasEdge(source, dest) || source.equals(dest))
            return;

        map.get(source).addAdjVertex(map.get(dest),weight);

        if (undirected)
            map.get(dest).addAdjVertex(map.get(source),weight);
    }

    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<V> v : map.values()) {
            count += v.getAdjVertices().size();
        }

        if (undirected)
            count = count / 2;

        return count;
    }


    public boolean hasVertex(V v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(V source, V dest) {
        if (hasVertex(source)) {
            return map.get(source).getAdjVertices().containsKey(map.get(dest));
        }
        return false;
    }

    public Iterable<V> adjacencyList(V v) {
        if (!hasVertex(v)) return null;
        List<V> vertices = new LinkedList<>();
        for (Vertex<V> vertex : getEdges(v)) {
            vertices.add(vertex.getData());
        }
        return vertices;
    }

    public Iterable<Vertex<V>> getEdges(V v) {
        if (!hasVertex(v)) return null;
        return map.get(v).getAdjVertices().keySet();
    }

    public Iterable<V> getVertices() {
        return map.keySet();
    }

}