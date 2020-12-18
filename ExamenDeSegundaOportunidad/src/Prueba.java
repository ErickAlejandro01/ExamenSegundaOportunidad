
import java.util.*;
import java.lang.*;
import java.io.*;
class ShortestPath
{
    static final int V=9;
	private int[] dist;
    int minDistance(int dist[], Boolean sptSet[])
    {
        int min = Integer.MAX_VALUE, min_index=-1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min)
            {
                min = dist[v];
                min_index = v;
            }
        return min_index;
    }
    void printSolution(int dist[], int n)
    {
        System.out.println("Vertex Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i+" \t\t "+dist[i]);
    }
    void dijkstra(int graph[][], int src)
    {
        Boolean sptSet[] = new Boolean[V];
        for (int i = 0; i < V; i++)
        {
            dist[i] = Integer.MAX_VALUE;
            sptSet[i] = false;
        }
        dist[src] = 0;
        for (int count = 0; count < V-1; count++)
        {
            int u = minDistance(dist, sptSet);
            sptSet[u] = true;
            for (int v = 0; v < V; v++)

                if (!sptSet[v] && graph[u][v]!=0 &&
                        dist[u] != Integer.MAX_VALUE &&
                        dist[u]+graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
        }
        printSolution(dist, V);
    }
class FloydWarshall{
	 	private static final int INFINITO = 0;
		private static final int TAM = 0;
		private int numNodos;
	 	private int[][] arcos = new int[TAM][TAM];
	 	private boolean[][] warshallC = new boolean[TAM][TAM];
	 public void warshall() {
	 		int i, j, k;
			for (i = 0; i < numNodos; i++)
				for (j = 0; j < numNodos; j++)
					warshallC[i][j] = (arcos[i][j] != INFINITO);
	
			for (k = 0; k < numNodos; k++)
				for (i = 0; i < numNodos; i++)
					for (j = 0; j < numNodos; j++)
						warshallC[i][j] = (warshallC[i][j] || (warshallC[i][k] && warshallC[k][j]));
		}
}
	
	public class BellmanFord {

	    private LinkedList aristas;
	    private float etiquetas[];
	    private int predecesor[];
	    private int numeroVertices, totalAristas, nodoOrigen;
	    private final int INFINITY = 999;
	    private  class Aristas {
	        int origen,destino;
	        float coste;

	        public Aristas(int a, int b, float c) {
	            origen = a;
	            destino = b;
	            coste = c;
	        }
	        public String toString() {
	            return "Aristas{" + "origen=" + origen + ", destino=" + destino + ", coste=" + coste + '}';
	        }
	    }
	    public BellmanFord() throws IOException {
	        float item;
	        aristas = new LinkedList();
	        DataInputStream in = new DataInputStream(System.in);
	        System.out.print("Introduce numero de vertices ");
	        numeroVertices = Integer.parseInt(in.readLine());
	        System.out.println("Matriz de costes");
	        for (int i = 0; i < numeroVertices; i++) {
	            for (int j = 0; j < numeroVertices; j++) {
	                if (i != j) {
	                    System.out.println("Introduce coste del nodo " + (i + 1) + " al nodo " + (j + 1));
	                    item = Float.parseFloat(in.readLine());
	                    if (item != 0) {
	                        aristas.add(new Aristas(i, j, item));
	                    }
	                }
	            }
	        }
	        totalAristas = aristas.size();
	        etiquetas = new float[numeroVertices];
	        predecesor = new int[numeroVertices];
	        System.out.print("Introduce el vertice origen");
	        nodoOrigen = Integer.parseInt(in.readLine()) - 1;
	    }
	    private void relajoArista() {
	        int i, j;
	        for (i = 0; i < numeroVertices; ++i) {
	            etiquetas[i] = INFINITY;
	        }
	        etiquetas[nodoOrigen] = 0;
	        for (i = 0; i < numeroVertices - 1; ++i) {
	            for (j = 0; j < totalAristas; ++j) {
	                System.out.println(aristas.get(j));
	                if (etiquetas[aristas.get(j).origen] + aristas.get(j).coste < etiquetas[aristas.get(j).destino]) {
	                    etiquetas[aristas.get(j).destino] = etiquetas[aristas.get(j).origen] + aristas.get(j).coste;
	                    predecesor[aristas.get(j).destino] = aristas.get(j).origen;
	                }
	            }
	            for (int p = 0; etiquetas.length < p; p++) {
	                System.out.println("\t" + etiquetas[p]);
	            }
	        }
	    }
	    private boolean ciclo() {
	        int j;
	        for (j = 0; j < totalAristas; ++j) {
	            if (etiquetas[aristas.get(j).origen] + aristas.get(j).coste < etiquetas[aristas.get(j).destino]) {
	                return false;
	            }
	        }
	        return true;
	    }
}
public class Prueba {

	public void main(String[] args) {
		Scanner input = new Scanner(System.in);
		int opc;
		do {
			System.out.println("1)BellmanFord\n"
					+ "2)FloydWarshall\n"
					+ "3)DIJKSTRA\n"
					+ "4)Salir");
			switch (opc) {
			case 1:
				BellmanFord bellman = new BellmanFord();
		        bellman.relajoArista();
		        if (bellman.ciclo()) {
		            for (int i = 0; i < bellman.numeroVertices; i++) {
		                System.out.println("Coste desde " + bellman.nodoOrigen + " a " + (i + 1) + " =>" + bellman.etiquetas[i]);
		            }
		            for (int i = 0; i < bellman.numeroVertices; i++) {
		                System.out.println("El predecesor de " + (i + 1) + " es " + (bellman.predecesor[i] + 1));
		            }
		        } else {
		            System.out.println("Hay un ciclo negativo");
		        }
		    }
		}
				break;
			case 2:
				break;
			case 3:
				int graph[][] = new int[][]{{},
				ShortestPath t = new ShortestPath();
				t.dijkstra(graph, 0);}
				break;
			default:
				System.out.println("opción no válida");
				break;
			}
		}
	}
}
				
		
	

	
	
	
	
	


