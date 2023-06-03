import java.util.LinkedList;
import java.util.Queue;

public class BFS<V> extends Search<V> {

    public BFS(WeightedGraph<V> graph, V source) {
        super(source);
        bfs(graph, source);
    }

    private void bfs(WeightedGraph<V> graph, V current) {
        marked.add(current);
        Queue<V> queue = new LinkedList<>();
        queue.offer(current);

        while (!queue.isEmpty()) {
            V vertex = queue.poll();

            for (V neighbor : graph.adjacencyList(vertex)) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    count++;
                    edgeTo.put(neighbor, vertex);
                    queue.offer(neighbor);
                }
            }
        }
    }
}
