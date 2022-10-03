import java.util.ArrayList;
import java.util.List;
import Structures.*;

public class Main {

    private static Queue<Order> oQueue; //Auftreage werden inder Reihenfolge des eintreffens bearbeitet
    private static List<Order> orders; //Auftraege muessen vorher noch sortiert werden
    private static int time;
    public static int day = 60*8; 

    public static void main(String[] args) {
        System.out.println("start"); //debug
        orders = new ArrayList<Order>();
        oQueue = new Queue<Order>();
        time = 0;

        createOrders();
        proceeding();
    }

    private static void proceeding() {
        while(time < day) {
            if(!oQueue.isEmpty()) {

                int bearbeitungsdauer = oQueue.front().getBearbeitungsdauer();

                if(oQueue.front().getEingangszeitpunkt() < time) { // ist der Auftrag vor der aktuellen Zeit eingegangen. Eigentlich mit clock loesen und Auftraege waerend des ablaufes des progamms einfügen


                    if(bearbeitungsdauer + time < day) { //ist noch genug zeit vorhanden fuer einen kompletten Auftrag

                        time = time + bearbeitungsdauer;
                        System.out.println("Auftrag in " + bearbeitungsdauer + "min bearbeitet");
                        oQueue.dequeue();

                    } else {

                        int timeover = -(day - time) + bearbeitungsdauer;
                        oQueue.front().setBearbeitungsdauer(timeover);
                        System.out.println("Auftrag angefangen:" + timeover + "min verbleibend");
                        time = time + (day - time);
                    }
                } else {
                    time++;
                }
            }
        }
    }

    private static void createOrders() {
        for(int i=0;i<30;i++) {
            oQueue.enqueue(new Order(i*40, 41)); //zeit des eintreffens und laenge
        }
    }
}
