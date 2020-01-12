/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paskaita_2020_01_09;

/**
 *
 * @author rimid
 */
public class LinkedSarasas {

    private Link head;

    public LinkedSarasas() {
        head = null;
    }

    //Inner class
    private class Link {

        Object value;
        Link next;
        Link prev;
        //is pradziu visos reiksmes null
    }

    //Metodas add
    public void add(Object o) {
        Link l = new Link();
        l.value = o;

        if (head == null) {
            head = l;
            return;
        }
        Link last = head;
        while (last.next != null) {
            last = last.next;
        }
        last.next = l;
        l.prev = last;
    }

    //Method size
    public int size() {
        if (head == null) {
            return 0;
        }
        int i = 1;
        Link last = head;
        while (last.next != null) {
            i++;
            last = last.next;
        }
        return i;
    }

    //Method get
    public Object get(int i) {
        if (i < 0 || i >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        Link last = head;
        int ci = 0;
        while (ci < i) {
            ci++;
            last = last.next;
        }
        return last.value;
    }

    //Method remove
    public void remove(int i) {
        if (i < 0 || i >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        Link last = head;
        int ci = 0;
        if (i == 0) {
            head = last.next;
        }
        while (last.next != null) {
            if (ci == i - 1) {
                last.next = last.next.next;
                break;
            } else {
                last = last.next;
                ci++;
            }
        }
    }

    //Method set element
    public void set(Object o, int i) {
        if (i < 0 || i >= this.size()) {
            throw new IndexOutOfBoundsException();
        }
        Link last = head;

        int ci = 1;
        if (i == 0) {
            head.value = o;
        }
        while (last.next != null) {
            if (ci == i ) {
                last = last.next;
                last.value = o;
                break;
            }
            last = last.next;
            ci++;

        }

       
}

//Method print 
public String toString() {
        if (head == null) {
            return "Sarasas nulinis";
        }
        String s = "{";
        Link last = head;
        while (last.next != null) {
            s += last.value + " ";
            last = last.next;
        }
        s += last.value;
        s += "}";
        return s;

    }
}

/*

ND
Padaryti
remove
set
toString

 */
