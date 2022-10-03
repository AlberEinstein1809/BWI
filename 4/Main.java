import java.util.ArrayList;
import java.util.List;
import Structures.*;

public class Main {

    private static Queue<Order> oQueue;
    private static List<Order> orders;
    private static int time;
    public static int day = 60*8; 

    public static void main(String[] args) {
        System.out.println("start");
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

                if(oQueue.front().getEingangszeitpunkt() < time) {

                    if(bearbeitungsdauer + time < day) {

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
            oQueue.enqueue(new Order(i*40, 41));
        }
    }
}
