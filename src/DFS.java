import java.util.*;

public class DFS<V> extends Search<V> {
    public DFS(WeightedGraph<V> graph, V source) {
        super(source);
        dfs(graph, source);
    }

    private void dfs(WeightedGraph<V> graph, V current) {
        marked.add(current);
        count++;

        Stack<V> stack = new Stack<>();
        stack.push(current);

        while (!stack.isEmpty()) {
            V vertex = stack.pop();

            for (V neighbor : graph.adjacencyList(vertex)) {
                if (!marked.contains(neighbor)) {
                    marked.add(neighbor);
                    count++;
                    edgeTo.put(neighbor, vertex);
                    stack.push(neighbor);
                }
            }
        }
    }
}
