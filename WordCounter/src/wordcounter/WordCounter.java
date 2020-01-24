package wordcounter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rimid
 */
public class WordCounter {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException
     * @throws java.io.UnsupportedEncodingException
     */
    public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException, IOException {

        String folderPath = "C:\\Users\\rimid\\Documents\\NetBeansProjects\\WordCounter\\Text\\";
        String file = "a.txt";
        String s;

        List<String> ls = new ArrayList();
//File reading activation
        InputStream is = new FileInputStream(folderPath + file);
        Reader r = new InputStreamReader(is, "UTF-8");
        BufferedReader br = new BufferedReader(r);
//Words list constructing from file
        while ((s = br.readLine()) != null) {
            String[] spn = s.split(" ");
            for (String spn1 : spn) {
                if (!spn1.isEmpty()) {
                    ls.add(spn1);
                }
            }
        }
//Stream closing
        br.close();
        r.close();
        is.close();

        System.out.println("Nuskaitytas tekstas:        " + ls);
        System.out.println("--------------------------------");

        int c = (int) ls.stream().filter(ss -> ss.length() > 5).count();
        System.out.println("Zodziu kiekis turinciu daugiau nei 5 simbolius yra:     " + c);
        System.out.println("--------------------------------");

        int sc = (int) ls.stream().flatMap(ss -> {
            List<Character> cl = new ArrayList();
            for(char ccc:ss.toCharArray()){
                cl.add(ccc);
            }
            return cl.stream();
    }).count();
        System.out.println("Tekste yra viso simboliu:     " + sc);
        System.out.println("--------------------------------");

    }

}
