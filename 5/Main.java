
/**
 * Beschreiben Sie hier die Klasse main.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.io.*;

public class Main{
    private Graph graph;

    public static void main(String[] args) throws IOException
    {
        FileReader fr = new FileReader("C:\\Users\\Nutzer\\Documents\\BWINF\\Material\\Aufgabe5\\huepfburg0.txt");
        BufferedReader br = new BufferedReader(fr);

        List<Edge> edges = new ArrayList<Edge>();
        int a = 0;
        while (br.readLine() != null) {
            a++;

        }
        br.close();
        FileReader fr2 = new FileReader("C:\\Users\\Nutzer\\Documents\\BWINF\\Material\\Aufgabe5\\huepfburg0.txt");
        BufferedReader br2 = new BufferedReader(fr2);
        for (int i = 0; i < a; i++) {

            String aa = br2.readLine();
            String[] aaa = aa.split(" ");
            String start = aaa[0];
            String end = aaa[1];
            int start2 = Integer.parseInt(start);
            int end2 = Integer.parseInt(end);
            edges.add(new Edge(start2, end2));
        }
        br2.close();
        Graph graph = new Graph(edges);
        graph.printGraph(graph);

        int anzStufe = 10;
        int vertex = 8;
        List<List<Integer>> tr = graph.wegFinden(vertex, graph, anzStufe);
        System.out.println(tr);
        int anzahl = 0;
        for (int i = 0; i < tr.size(); i++) {
            anzahl += tr.get(i).size();
        }
        System.out.println(anzahl);
        System.out.println("Knoten" + vertex);
        int gleicheStufe = -1;
        for (int i = 0; i < anzStufe; i++) {
            System.out.println("current stage:" + i);
                List<Integer> current = tr.get(i);
                if (current.contains(1) && current.contains(2)) {
                    gleicheStufe = i;
                    break;
                }
                else {
                    
                }
           

            }
        System.out.println("erste gleiche Stufe: "+ gleicheStufe);
        
    }
}

