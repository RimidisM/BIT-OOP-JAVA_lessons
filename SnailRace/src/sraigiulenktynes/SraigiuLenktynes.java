package sraigiulenktynes;

import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author rimid
 */
public class SraigiuLenktynes {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Sraige s1 = new Sraige("Sraigius 1");
        Sraige s2 = new Sraige("Sraigius 2");
        Sraige s3 = new Sraige("Sraigius 3");
        Sraige s4 = new Sraige("Sraigius 4");
        Sraige s5 = new Sraige("Sraigius 5");
        Sraige s6 = new Sraige("Sraigius 6");
        Sraige s7 = new Sraige("Sraigius 7");
        Sraige s8 = new Sraige("Sraigius 8");

//        Thread t1 = new Thread(() -> {
//
//            while (s1.endDist < 100) {
//                s1.addD();
//                int rest = (int) (Math.random() * ((200 - 50) + 1) + 50);
//                try {
//                    Thread.sleep(rest);
//                } catch (InterruptedException ex) {
////                    TODO:
//                }
//
//                if (s1.endDist % 10 == 0) {
//
//                    System.out.println(s1.name + " judu, atstumas lygus: " + s1.endDist + " cm");
//                }
//            }
//        });
//        Thread t2 = new Thread(() -> {
//            Date d = new Date();
//            while (s2.endDist < 100) {
//                s2.addD();
//                int rest = (int) (Math.random() * ((200 - 50) + 1) + 50);
//                try {
//                    Thread.sleep(rest);
//                } catch (InterruptedException ex) {
////                    TODO:
//                }
//
//                if (s2.endDist % 10 == 0) {
//                    System.out.println(s2.name + " judu, atstumas lygus: " + s2.endDist + " cm");
//                }
//            }
//            Date d1 = new Date();
//            long st = d1.getTime() - d.getTime();
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//            System.out.println(" kirto finisa, atstuma iveike per: " + st + " mills");
//            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
//        });


        s1.start();
        s2.start();
        s3.start();
        s4.start();
        s5.start();
        s6.start();
        s7.start();
        s8.start();

        
        
        
    }

}
