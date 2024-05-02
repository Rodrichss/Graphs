import java.util.Arrays;
import java.util.Vector;

public class Graph {
    int [][] mAdy;
    Vector<Node> nodes;

    public Graph(int size){
        mAdy = new int[size][size];
        nodes = new Vector<>();
    }

    public void addNode(Node node){
        nodes.add(node);
    }

    public void addEdge(int source, int destination, int weight){
        mAdy[source][destination] = weight;
        mAdy[destination][source] = weight;
    }

    public void print(){
        System.out.print("  ");
        for (Node node : nodes) {
            System.out.print(node.data+" ");
        }
        System.out.println();

        for(int i=0;i<mAdy.length;i++){
            System.out.print(nodes.get(i).data+ " ");
            for(int j=0;j<mAdy.length;j++){
                System.out.print(mAdy[i][j]+" ");
            }
            System.out.println();
        }
    }

    public void shortestPath(int inicio, int fin){
        int size = mAdy.length;
        boolean[] explored = new boolean[size];
        int[] pesoViaje = new int[size];

        Arrays.fill(explored,false);
        Arrays.fill(pesoViaje, Integer.MAX_VALUE);

        int actual = inicio;
        
        explored[actual] = true;
        pesoViaje[actual] = 0;

        for(int i=0;i<size-1;i++){
            //update estimates
            for(int j=0;j<size;j++){
                if(!explored[j] && mAdy[actual][j]>0 && 
                pesoViaje[actual]+mAdy[actual][j]<pesoViaje[j]){
                    pesoViaje[j] = pesoViaje[actual]+mAdy[actual][j];
                }
            }
            //choose next vertex
            int shortest=-1;
            for(int k=0;k<pesoViaje.length;k++){
                if((shortest==-1||pesoViaje[k]<pesoViaje[shortest])&&!explored[k]){
                    shortest = k;
                    actual = shortest;
                }
            }
            explored[actual] = true;
            if(actual==fin){
                break;
            }
        }
        System.out.println("Peso del camino más corto: " + pesoViaje[fin]);

    }

    /*public boolean checkEdge(int source, int destination){
        if(mAdy[source][destination]==1){
            return true;
        }else{
            return false;
        }
    }*/
}

