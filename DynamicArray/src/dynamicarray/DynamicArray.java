package dynamicarray;

/**
 *
 * @author rimid
 */
public class DynamicArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Sarasas s = new Sarasas();
        s.add("labas");
        s.add("pasauli");
        System.out.println(s);
        s.add("!");
        s.add(5);
        System.out.println(s);
        s.add(null);
        System.out.println(s);
        s.remove(1);
        System.out.println(s);
    }

}
