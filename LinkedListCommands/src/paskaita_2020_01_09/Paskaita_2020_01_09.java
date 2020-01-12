package paskaita_2020_01_09;

/**
 *
 * @author rimid
 */
public class Paskaita_2020_01_09 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        LinkedSarasas object = new LinkedSarasas();

        object.add("A");
        object.add("B");
        object.add("C");
        object.add("D");
        object.add("E");
        object.add("F");
        object.add("G");

        System.out.println("LinkedSaraso dysis yra:   " + object.size());
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("Jusu nurodytas objektas LinkedSarase yra:   " + object.get(1));
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        object.remove(1);
        
        object.set("{D} yra Pakeistas", 2);
        
        System.out.println("Dabartinis LinkedSaras yra:   " + object.toString());
    }
}


/*
Exception reikalingi pagrinde pranesti apie kalida
Exception galima apdoroti ir testi programa toliau

Runtime (uncheck) exceptionai neprivalome deklaruoti ir gaudyti

   (check)exceptionai visi kiti, kuriuos throvinam ir juos privalome deklaruoti, jei kevieciam metoda su throw privalome gaudyti

LinkedList------------------------------------------------------------

Metodu saras get,size, add, set, toString, remove

Reikia pasidaryti toki sarasa, kitokiu budu.

LinkedList saugo duomenis ne masyve, o objektuose kurie turi reference vienas i kita



*/
