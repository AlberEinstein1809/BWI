
/**
 * Beschreiben Sie hier die Klasse graph.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Graph
{
    
    // Eine Liste von Listen zur Darstellung einer Adjazenzliste
    List<List<Integer>> adjList = new ArrayList<>();
 
    // Konstruktor zum Erstellen eines Diagramms
    public Graph(List<Edge> edges)
    {
        // finden Sie den höchsten nummerierten Scheitelpunkt
        int n = 0;
        for (Edge e: edges) {
            n = Integer.max(n, Integer.max(e.src, e.dest));
        }
 
        // Speicher für die Adjazenzliste zuweisen
        for (int i = 0; i <= n; i++) {
            adjList.add(i, new ArrayList<>());
        }
 
        // füge dem gerichteten Graphen Kanten hinzu
        for (Edge current: edges)
        {
            // Neuen Knoten in der Adjazenzliste von Quelle zu Ziel zuweisen
            adjList.get(current.src).add(current.dest);
 
            // Entkommentiere unter der Zeile für ungerichteten Graphen
 
            // Neuen Knoten in Adjazenzliste von dest zu src zuweisen
            // adjList.get(current.dest).add(current.src);
        }
    }
 
    
    // Funktion zum Drucken der Adjazenzlistendarstellung eines Diagramms
    public void printGraph(Graph graph)
    {
        int src = 0;
        int n = graph.adjList.size();

        while (src < n) {
            // Aktuellen Scheitelpunkt und alle seine benachbarten Scheitelpunkte drucken
            for (int dest : graph.adjList.get(src)) {
                System.out.print("(" + src + " ——> " + dest + ")\t");
            }
            System.out.println();
            src++;
        }
    }
    
    public int getSize() {
        return adjList.size();
    }

    public boolean wegDa(int start, int end) {
        List<Integer> kandidaten = adjList.get(start);
        if (kandidaten.contains(end)) {
            return true;
        }
        else {
            return false;
        }
    }
        
    

    public List<Integer> nachbarn(int vertex, Graph g) {
        List<Integer> ret = new ArrayList<>();
        if (wegDa(1, vertex) == true) {
            ret.add(1);
        }
        else {
            for (int i = 0; i < 21; i++) {
                if (wegDa(i, vertex)) {
                    ret.add(i);
                }
            }

        }
        return ret;
    }

    public List<List<Integer>> wegFinden(int vertex, Graph g, int stufe) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> stufe1 = new ArrayList<>();
        stufe1.add(vertex);
        list.add(stufe1);
        for (int i = 0; i < stufe; i++) {
            List<Integer> vorherigeStufe = new ArrayList<>();
            vorherigeStufe = list.get(i);
            List<Integer> neueNachbarn = new ArrayList<>();
            for (int j : vorherigeStufe) {
                for (int k : nachbarn(j, g)) {
                    neueNachbarn.add(k);
                }
            }
            list.add(neueNachbarn);
        }
        return list;
    }

    public List<List<Integer>> getAdjList() {
        return adjList;
    }
}

