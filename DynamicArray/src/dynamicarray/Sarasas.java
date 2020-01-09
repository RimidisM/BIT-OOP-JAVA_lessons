package dynamicarray;

/**
 *
 * @author rimid
 */
public class Sarasas {

    private Object[] m;
//Sukuriame konstruktoriu

    public Sarasas() {
        this.m = new Object[0];
    }
//    Dydzio metodas

    public int size() {
        return m.length;
    }
//    Pridejimo metodas

    public void add(Object o) {
        Object[] nm = new Object[m.length + 1];
        System.arraycopy(m, 0, nm, 0, m.length);
        nm[m.length] = o;
        m = nm;
    }

    //    Istraukimo metodas
    public Object get(int i) {
        if (i < 0 || i >= m.length) {
            return null;
        }
        return m[i];
    }

    //    Pakeitimo metodas
    public void set(int i, Object o) {
        if (i < 0 || i >= m.length) {
            throw new IllegalArgumentException("Neteisingas parametras");

        }
        m[i] = o;
    }

    //    Panaikinimo metodas
    public void remove(int i) {
        if (i < 0 || i >= m.length) {
            throw new IllegalArgumentException("Neteisingas parametras");
        }
        Object[] nm = new Object[m.length - 1];
        System.out.println(m.length);
        System.arraycopy(m, 0, nm, 0, i);
        System.arraycopy(m, i + 1, nm, i, nm.length - i);
        m = nm;
    }
//    Spausdinimo eilute metodas

    public String toString() {
        String s = "{";
        for (int i = 0; i < m.length; i++) {
            if (m[i] != null) {
                s += m[i].toString();
            } else {
                s += "null";
            }
            if (i != m.length - 1) {
                s += ",";
            }
        }
        s += "}";
        return s;
    }
}
