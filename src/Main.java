public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graphW = new WeightedGraph<>(true);

        graphW.addEdge("CityA", "CityB", 2.1);
        graphW.addEdge("CityA", "CityC", 7.2);
        graphW.addEdge("CityC", "CityB", 3.9);
        graphW.addEdge("CityB", "CityD", 3.5);
        graphW.addEdge("CityC", "CityE", 5.4);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graphW, "CityA");
        outputPath(djk, "CityD");

        MyGraph<String> graph = new MyGraph<>();

        System.out.println("\n--------------------------------");

        graph.addEdge("CityA", "CityB");
        graph.addEdge("CityA", "CityC");
        graph.addEdge("CityC", "CityB");
        graph.addEdge("CityB", "CityD");
        graph.addEdge("CityC", "CityE");

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(graph, "CityA");
        outputPath(dfs, "CityD");

        System.out.println("\n--------------------------------");

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(graph, "CityA");
        outputPath(bfs, "CityD");
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
    }
}
