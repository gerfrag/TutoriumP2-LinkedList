public class LinkedList {
    Node anfang;
    
    public void add(int zahl){
       if (anfang == null){
           anfang = new Node(zahl);
           return;
       } 
       Node aktuell = anfang;
       while (aktuell.next != null){
           aktuell = aktuell.next;
       }
       aktuell.next = new Node(zahl);
               
    }
    
    public void remove(int zahl){
        // Fall 1: Die Liste ist leer
        if (anfang == null) {
            return;
        }

        // Fall 2: Das zu löschende Element ist direkt am Anfang
        if (anfang.value == zahl) {
            anfang = anfang.next;
            return;
        }

        // Fall 3: Das Element suchen (wir brauchen den Vorgänger)
        Node aktuell = anfang;
        while (aktuell.next != null) {
            if (aktuell.next.value == zahl) {
                // Den Knoten überspringen ("umbiegen")
                aktuell.next = aktuell.next.next;
                return;
            }
            aktuell = aktuell.next;
        }
    }
    
    public void print(){
        Node aktuell = anfang;
        while (aktuell != null){
            System.out.print(aktuell.value + " -> ");
            aktuell = aktuell.next;
        }
        System.out.print("Ende");
        System.out.println("\n=== Liste abgeschlossen ===");
            
                
    }
    
}
