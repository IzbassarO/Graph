public class Main {
    public static void main(String[] args) {
        WeightedGraph<String> weightedGraph = new WeightedGraph<>(true);

        weightedGraph.addEdge("Almaty", "Astana", 2.1);
        weightedGraph.addEdge("Almaty", "Shymkent", 7.2);
        weightedGraph.addEdge("Shymkent", "Astana", 3.9);
        weightedGraph.addEdge("Astana", "Kostanay", 3.5);
        weightedGraph.addEdge("Shymkent", "Kyzylorda", 5.4);

        System.out.println("Dijkstra:");
        Search<String> djk = new DijkstraSearch<>(weightedGraph, "Almaty");
        outputPath(djk, "Kyzylorda");

        MyGraph<String> myGraph = new MyGraph<>();

        myGraph.addEdge("Almaty", "Astana");
        myGraph.addEdge("Almaty", "Shymkent");
        myGraph.addEdge("Shymkent", "Astana");
        myGraph.addEdge("Astana", "Kostanay");
        myGraph.addEdge("Shymkent", "Kyzylorda");

        System.out.println();

        System.out.println("DFS:");
        Search<String> dfs = new DepthFirstSearch<>(myGraph, "Almaty");
        outputPath(dfs, "Kyzylorda");

        System.out.println();

        System.out.println("BFS:");
        Search<String> bfs = new BreadthFirstSearch<>(myGraph, "Almaty");
        outputPath(bfs, "Kyzylorda");
    }

    public static void outputPath(Search<String> search, String key) {
        for (String v : search.pathTo(key)) {
            System.out.print(v + " -> ");
        }
    }
}

