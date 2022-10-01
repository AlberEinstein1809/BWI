import java.util.ArrayList;
import java.util.List;
import Structures.*;

public class Main {

    private static Queue<Order> oQueue;
    private static List<Order> orders;
    private static int time;
    public static int day = 60*8; 

    public static void main(String[] args) {
        orders = new ArrayList<Order>();
        oQueue = new Queue<Order>();
        time = 0;

        createOrders();
        proceeding();
    }

    private static void proceeding() {
        while(time < day) {
            if(!oQueue.isEmpty()) {

                if(oQueue.front().getEingangszeitpunkt() > time) {

                    if(oQueue.front().getBearbeitungsdauer() + time > day) {

                        time = time + oQueue.front().getBearbeitungsdauer();
                        System.out.print("Auftrag in " + oQueue.front().getBearbeitungsdauer() + " bearbeitet");
                        oQueue.dequeue();

                    } else {

                        int timeover = -(day - time) + oQueue.front().getBearbeitungsdauer();
                        oQueue.front().setBearbeitungsdauer(oQueue.front().getBearbeitungsdauer() - timeover);
                        time = time + (day - time);
                    }
                } else {

                    time++;
                }
            }
            time++;
        }
    }

    private static void createOrders() {
        for(int i=0;i<10;i++) {
            oQueue.enqueue(new Order(i*40, 40));
        }
    }
}
