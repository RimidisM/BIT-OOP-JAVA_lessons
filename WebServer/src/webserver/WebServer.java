package webserver;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import jdk.nashorn.internal.runtime.JSType;

/**
 *
 * @author rimid
 */
public class WebServer {

    /**
     * @param args the command line arguments
     * @throws java.io.IOException
     */
    public static void main(String[] args) throws IOException {

        String[][] fn = {
            {"a", "Pirmas"},
            {"Labas", "Antras"},
            {"c", "Trecias"},
            {"d", "Ketvirtas"},
            {"rytas", "Penktas"},
            {"f", "Sestas"},
            {"g", "Septintas"},
            {"h", "Astuntas"},
            {"Testas", "Testas"},
            {"Link", "Linkai"}
        };

        for (int i = 0; i < fn.length; i++) {
            for (int j = 0; j < 2; j++) {
                if (fn[i][0] == "Link") {
                    addLinks(fn[i][0], fn[i][1]);
                    break;
                } else {
                    addFiles(fn[i][0], fn[i][1]);
                }
            }
        }
        ServerSocket ss = new ServerSocket(8000);
        String pn = "";

        while (true) {

//            String last = "";
//            for (int i = 0; i < fn.length; i++) {
//                for (int j = 0; j < 1; j++) {
//                    int kiek = (int) (Math.random() * (((fn.length - 1) - 0) + 1)) + 0;
//                    last = fn[kiek][0];
//                }
//            }
            Socket s = ss.accept();
            Reader r = new InputStreamReader(s.getInputStream(), "UTF-8");
            BufferedReader br = new BufferedReader(r);

            String st;

            do {
                st = br.readLine();
                System.out.println(st);

                if (st.contains("GET /favicon.ico HTTP/1.1")) {

                    continue;
//                   
                } else if (st.contains("GET /")) {
                    String[] spn = st.split("GET /");
//                    System.out.println(spn.length);
//                    if (spn.length != 0) {
                    for (int d = 0; d < 2; d++) {

                        String spn0 = spn[1];

                        String[] spn1 = spn0.split(" ");
                        for (int k = 0; k < 2; k++) {
//                                System.out.println(spn1[0]);
//                                System.out.println(spn1[1]);
                            pn = spn1[0];
                        }
                    }
                }

            } while (st != null && !st.equals(""));

            System.out.println(pn);

            Writer w = new OutputStreamWriter(s.getOutputStream(), "UTF-8");

            BufferedWriter bw = new BufferedWriter(w);

            bw.write("HTTP/1.1 200 ok");
            bw.newLine();
            bw.newLine();

            InputStream is = new FileInputStream("c:\\Users\\rimid\\JavaServer\\" + pn + ".txt");
            //Duoda viena char gauna baita
            //Readeris ksiato baitus tol kol susidaro simbolis
            Reader rr = new InputStreamReader(is, "UTF-8");
            //Gauna chara
            //Jei sitas negauna nei vieno simbolio grazina null
            BufferedReader brr = new BufferedReader(rr);

            String sss;

            //Nuskaitome eilute
            while ((sss = brr.readLine()) != null) {
//                System.out.println(sss);
                bw.write(sss);
                bw.newLine();  //tas pats kas bw.write("\r\n")
            }

            bw.flush();
            bw.close();
            w.close();
//            s.close();

            //Uzdarymas vyksta atvirkstine tvarka nei atidaromi
            br.close();
            r.close();
            is.close();

        }
//        s.close();
    }
    //Add new files to folder

    public static void addFiles(String fn, String pageName) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        OutputStream oss = new FileOutputStream("C:\\Users\\rimid\\JavaServer\\" + fn + ".txt");
        Writer ww = new OutputStreamWriter(oss, "UTF-8");
        BufferedWriter bww = new BufferedWriter(ww);

        String s = "<!DOCTYPE html>\n"
                + "<html lang=\"en\">\n"
                + "<head>\n"
                + "    <meta charset=\"UTF-8\">\n"
                + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
                + "    <title>" + pageName + "</title>\n"
                + "</head>\n"
                + "<body style=\"background-color:rgb(234, 235, 237);\">\n"
                + "    \n"
                + " <!-- kaire -->\n"
                + " <div> \n"
                + "        <img src=\"https://ya-webdesign.com/transparent600_/funny-animal-png-15.png\" \n"
                + "        style=\"position:fixed; right:1100px; bottom:200px; border:none;\"\n"
                + "        alt=\"No way Sherlock\">\n"
                + "            \n"
                + "              \n"
                + "            <!-- desine -->\n"
                + "            <div>\n"
                + "                <h1  style=\"position:fixed; right:470px; bottom:500px; border:none;\">Pavyko failas " + fn + " buvo sukurtas ir nuskaitytas</h1>\n"
                + "                <p style=\"position:fixed; right:610px; bottom:400px; border:none;\">\n"
                + "                    Looks like this page is working. You did it :) :) :) .\n"
                + "                </p>\n"
                + "                <p style=\"position:fixed; right:650px; bottom:300px; border:none;\">Meanwhile, why don't try again by going</p>\n"
                + "                <a style=\"position:fixed; right:750px; bottom:250px; border:none;\" href=\"http://localhost:8000/hello\" target=\"blink\" >BACK HOME </a>\n"
                + "            </div>\n"
                + "        </div>\n"
                + "\n"
                + "\n"
                + "</body>\n"
                + "</html>";

        // Irasome s reiksme i faila
//        System.out.println(s);
        bww.write(s);
        bww.newLine();  //tas pats kas bw.write("\r\n")

        //Suraso viska i diska, nelaukia kol prikaups paketa, nekesuoja
        bww.flush();
        //Uzdarymas
        bww.close();
        ww.close();
        oss.close();
    }

    public static void addLinks(String fn, String pageName) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        OutputStream oss = new FileOutputStream("C:\\Users\\rimid\\JavaServer\\" + fn + ".txt");
        Writer ww = new OutputStreamWriter(oss, "UTF-8");
        BufferedWriter bww = new BufferedWriter(ww);

        File f = new File("C:\\Users\\rimid\\JavaServer\\");

        if (f == null) {
            return;
        }
        if (!f.exists()) {
            return;
        }
        if (f.isDirectory()) {
            File[] fl = f.listFiles();
            if (fl != null) {
                String dd = "";
                for (int i = 0; i < fl.length; i++) {
                    dd += JSType.toString(fl[i] + "<br><br>");
                }

                String s = "<!DOCTYPE html>\n"
                        + "<html lang=\"en\">\n"
                        + "<head>\n"
                        + "    <meta charset=\"UTF-8\">\n"
                        + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n"
                        + "    <meta http-equiv=\"X-UA-Compatible\" content=\"ie=edge\">\n"
                        + "    <title>" + pageName + "</title>\n"
                        + "</head>\n"
                        + "<body style=\"background-color:rgb(237, 237, 4);\">\n"
                        + "    \n"
                        + " <!-- kaire -->\n"
                        + " <div> \n"
                        + "        <img src=\"https://img.pngio.com/eureka-png-png-image-eureka-png-251_394.png\" \n"
                        + "        style=\"position:fixed; right:1100px; bottom:200px; border:none;\"\n"
                        + "        alt=\"No way Sherlock\">\n"
                        + "            \n"
                        + "              \n"
                        + "            <!-- desine -->\n"
                        + "            <div>\n"
                        + "                <h2  style=\"position:fixed; right:470px; bottom:100px; border:none;\">Nuorodos i failus: <br><br>" + dd + "</h1>\n"
                        + "            </div>\n"
                        + "        </div>\n"
                        + "\n"
                        + "\n"
                        + "</body>\n"
                        + "</html>";

                // Irasome s reiksme i faila
//        System.out.println(s);
                bww.write(s);
                bww.newLine();  //tas pats kas bw.write("\r\n")

                //Suraso viska i diska, nelaukia kol prikaups paketa, nekesuoja
                bww.flush();
                //Uzdarymas
                bww.close();
                ww.close();
                oss.close();
            }
        }
    }
}
