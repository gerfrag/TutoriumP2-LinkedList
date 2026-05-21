public class LinkedList {
    private Node head;

    // TODO: Schritt 1 - Den Anfang der Kette erstellen
    public void addHead(int data) {
        // Logik: Wir erzeugen einfach eine neue Node und deklarieren sie als Start
        head = new Node(data);
    }

    // TODO: Schritt 2 - Den Wert vom Kopf ausgeben
    public void printHead() {
        // Wichtig für die Studierenden: Immer prüfen, ob überhaupt etwas da ist!
        if (head != null) {
            System.out.println("Kopf-Wert: " + head.data);
        } else {
            System.out.println("Die Liste ist leer, kein Kopf vorhanden.");
        }
    }

    // TODO: Schritt 3 - Am Ende der Kette anfügen
    public void addLast(int data) {
        // Voraussetzung laut deiner Beschreibung: head existiert bereits!
        Node current = head;
        
        // Wir hangeln uns durch, bis wir die AKTUELL LETZTE Node gefunden haben
        while (current.next != null) {
            current = current.next;
        }
        
        // Wenn wir hier ankommen, ist current.next == null (also das Ende).
        // Jetzt hängen wir die neue Node hinten an.
        current.next = new Node(data);
    }
    
    // TODO: Schritt 4 - Die Werte der kompletten Liste ausgeben
    public void printList() {
        if (head == null) {
            System.out.println("Liste ist leer.");
            return;
        }

        Node current = head;
        // Wichtig: Hier prüfen wir auf 'current != null', weil wir AUCH die 
        // letzte Node noch ausgeben wollen, bevor die Schleife stoppt.
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    // TODO: Schritt 5 - Kombiniert addHead + addLast
    public void add(int data) {
        if (head == null) {
            addHead(data); // Fall A: Liste leer
        } else {
            addLast(data); // Fall B: Kette existiert schon
        }
    }
    
    // TODO: Schritt 6 - Hiermit wollen wir bestimmte Werte löschen
    public void delete(int data) {
        // Fall 1: Liste ist komplett leer
        if (head == null) 
            return;

        // Fall 2: Das zu löschende Element ist direkt der Kopf
        if (head.data == data) {
            head = head.next; // Der Kopf wandert ein Element weiter
            return;
        }

        // Fall 3: Das Element liegt irgendwo tiefer in der Kette
        Node current = head;
        // Wir suchen die Node VOR dem Element, das gelöscht werden soll
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }

        // Wenn wir den Übeltäter gefunden haben, biegen wir den Zeiger um
        if (current.next != null) {
            current.next = current.next.next; // Das Element dazwischen wird "übersprungen"
        }
    }
}