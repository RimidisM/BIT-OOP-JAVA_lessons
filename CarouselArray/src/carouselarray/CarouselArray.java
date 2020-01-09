/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package carouselarray;

/**
 *
 * @author rimid
 */
public class CarouselArray {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int[] m = {5, 6, 10, 3, 12};
        int[][] k = new int[5][5];
        for (int i = 0; i < m.length; i++) {
            int first = m[0];
            int last = m[m.length - 1];
            int s = 0;
            for (int j = 0; j < m.length - 1; j++) {
                if (i == 0) {
                    k[i][j] = m[j];
                } else {
                    m[j] = m[j + 1];
                    k[i][j] = m[j];
                }
            }
            if (i != 0) {
                m[m.length - 1] = first;
                k[i][m.length - 1] = first;
            } else {
                k[i][m.length - 1] = last;
            }
        }
        spausdinkAtsakyma(k);
    }

    public static void spausdinkAtsakyma(int[][] k) {
        for (int y = 0; y < k.length; y++) {
            int[] line = k[y];
            for (int x = 0; x < line.length; x++) {
                System.out.print(line[x] + " ");
            }
            System.out.println("");
        }
    }

}


/*
ND
int[] m = {5,6,10,3,12};
Susikurti masyva sveiku skaiciu ir jame parasyti kazkiek sveiku skaiciiu
rezultate sukurti kavdartini masyva kuris turetu tokius ksiacius
5 6 10 3 12
6 10 3 12 5
10 3 12 5 6
3 12 5 6 10
12 5 6 10 3
 pirmas atitinka paskui pirmas vis keliauja i pabaiga

*/