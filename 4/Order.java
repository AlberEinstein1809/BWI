public class Order {
    
    private int eingangszeitpunkt, bearbeitungsdauer;

    public Order(int eingangszeitpunkt, int bearbeitungsdauer) {
        this.eingangszeitpunkt = eingangszeitpunkt;
        this.bearbeitungsdauer = bearbeitungsdauer;
    }

    public int getBearbeitungsdauer() {
        return bearbeitungsdauer;
    }

    public int getEingangszeitpunkt() {
        return eingangszeitpunkt;
    }

    public void setBearbeitungsdauer(int bearbeitungsdauer) {
        this.bearbeitungsdauer = bearbeitungsdauer;
    }
}
