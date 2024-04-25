import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);

        Graph g1 = new Graph(7);
        

        g1.addNode(new Node(1));
        g1.addNode(new Node(2));
        g1.addNode(new Node(3));
        g1.addNode(new Node(4));
        g1.addNode(new Node(5));
        g1.addNode(new Node(6));
        g1.addNode(new Node(7));
        g1.addEdge(0, 2, 3);
        g1.addEdge(0, 5, 2);
        g1.addEdge(1, 3, 1);
        g1.addEdge(1, 4, 2);
        g1.addEdge(1, 5, 6);
        g1.addEdge(1, 6, 2);
        g1.addEdge(2, 3, 4);
        g1.addEdge(2, 4, 1);
        g1.addEdge(2, 5, 2);
        g1.addEdge(4, 5, 3);
        g1.addEdge(5, 6, 5);

        

        System.out.println("Grafo 1");
        g1.print();

        System.out.println("Ingrese el índice del nodo desde el que quiere iniciar");
        int inicio = sc.nextInt();
        System.out.println("Ingrese el índice del nodo al que quiere llegar");
        int fin = sc.nextInt();
        g1.shortestPath(inicio, fin);
    }
}
