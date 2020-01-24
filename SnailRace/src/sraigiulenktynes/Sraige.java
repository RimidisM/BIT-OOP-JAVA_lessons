/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sraigiulenktynes;

import java.util.Date;

/**
 *
 * @author rimid
 */
public class Sraige extends Thread {

    public String name;
    int endDist = 0;
    public long st = 0;

    public Sraige(String name) {
        this.name = name;
    }

    public void run() {
        Date d = new Date();

        while (endDist < 100) {
            endDist = endDist + 1;
//            System.out.println(endDist);
            int rest = (int) (Math.random() * ((200 - 10) + 1) + 10);
            try {
                Thread.sleep(rest);
            } catch (InterruptedException ex) {
//                    TODO:
            }
            if (endDist == 100) {
//                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//                System.out.println(name + " kirto finisa");
//                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(name + " judu, atstumas lygus: " + endDist + " cm");
                break;
            }
            if (endDist % 10 == 0) {

                System.out.println(name + " judu, atstumas lygus: " + endDist + " cm");
            }

        }
        Date d1 = new Date();
        st = d1.getTime() - d.getTime();
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        System.out.println("!!! " + name + " kirto finisa, atstuma iveike per: " + st + " mills");
        System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

    }


}
