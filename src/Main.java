public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> graph = new WeightedGraph<>();
        graph.addEdge("CityA", "CityB", 2.1);
        graph.addEdge("CityA", "CityC", 7.2);
        graph.addEdge("CityC", "CityB", 3.9);
        graph.addEdge("CityB", "CityD", 3.5);
        graph.addEdge("CityC", "CityE", 5.4);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(graph, "CityA");
        outputPath(djk, "CityD");
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
        System.out.println(key);
    }
}
