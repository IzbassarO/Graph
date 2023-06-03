public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>(true);

        graph.addEdge("CityA", "CityB", 2.1);
        graph.addEdge("CityA", "CityC", 7.2);
        graph.addEdge("CityC", "CityB", 3.9);
        graph.addEdge("CityB", "CityD", 3.5);
        graph.addEdge("CityC", "CityE", 5.4);

        String source = "CityA";
        String destination = "CityD";

        BFS<String> bfs = new BFS<>(graph, source);
        DFS<String> dfs = new DFS<>(graph, source);

        System.out.println("Breadth-First Search:");
        outputPath(bfs, destination);

        System.out.println("\n\nDepth-First Search:");
        outputPath(dfs, destination);
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
    }
}