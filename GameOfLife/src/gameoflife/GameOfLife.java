package gameoflife;

/**
 *
 * @author rimid
 */
public class GameOfLife {

    /**
     * @param args the command line arguments
     */     
    public static void main(String[] args) {
//Sukuriame pirmini gyvenimo lauka
        int d = 10;
        int ite = 50;
        int[][][] next = new int[ite][d][d];
        int[][][] before = new int[ite][d][d];

//Uzpildome lauka givybe su random pozicija
        for (int y = 0; y < d; y++) {
            for (int x = 0; x < d; x++) {
                next[0][y][x] = (Math.random() < 0.2) ? 1 : 0;
            }
        }
       
        System.out.println("Karta " + 0 + "--------------");
        spausdinkLauka(next, 0);
//Generuojame naujas kartas

//Tikriname ar karta unikali ir nesikartoja
        for (int z = 1; z < ite; z++) {
            int unikalumas = 0;
            for (int y = 0; y < d; y++) {
                for (int x = 0; x < d; x++) {
                    if (before[z - 1][y][x] != next[z - 1][y][x]) {
                        unikalumas++;
                    }
                    before[z][y][x] = next[z - 1][y][x];
                }
            }
            if (unikalumas == 0) {
                System.out.println("--------Sustabdyta, kartos pradejo kartotis--------");
                break;
            } else {
                sukurkNaujaKarta(d, next, z);
//                System.out.println("Karta " + z + "--------------");
//                spausdinkLauka(next, z);
            }
            //Tikriname ar istorijoje nebuvo tokios kartos

            for (int j = 1; j <= z; j++) {
                int unikalumas2 = 0;
                for (int y = 0; y < d; y++) {
                    for (int x = 0; x < d; x++) {
                        if (next[j - 1][y][x] != next[z][y][x]) {
                            unikalumas2++;
                        }
                    }
                }
                if (unikalumas2 == 0) {
                    System.out.println("------Pasikartojo " + (j - 1) + "--------------");
                    break;
                } else {
                    System.out.println("Tikrinama Karta " + j + "--------------");
                    spausdinkLauka(next, j);
                }
            }
        }

    }

    public static void sukurkNaujaKarta(int d, int[][][] next, int z) {
//Skaiciuojame kaimynus

        for (int y = 0; y < d; y++) {
            for (int x = 0; x < d; x++) {
                int kaimynai = 0;
                for (int dy = -1; dy <= 1; dy++) {
                    for (int dx = -1; dx <= 1; dx++) {
                        if (x + dx >= 0 && y + dy >= 0 && x + dx < d && y + dy < d) {
                            kaimynai += next[z - 1][y + dy][x + dx];
                        }
                    }
                }
                kaimynai -= next[z - 1][y][x];
//                System.out.println(kaimynai);

//Tikrinam gyvenimo salygas
                if (next[z - 1][y][x] == 1 && kaimynai < 2) {
                    next[z][y][x] = 0;
//                                            System.out.println("Turi mirti");
                } else if (next[z - 1][y][x] == 1 && kaimynai > 3) {
//                                            System.out.println("Turi mirti");
                    next[z][y][x] = 0;
                } else if (next[z - 1][y][x] == 0 && kaimynai == 3) {
//                                            System.out.println("Sukuriu gyventoja");
                    next[z][y][x] = 1;
                } else {
                    next[z][y][x] = next[z - 1][y][x];
                }
            }
        }

    }

    public static void spausdinkLauka(int[][][] next, int z) {

        for (int y = 0; y < next[z].length; y++) {
            for (int x = 0; x < next[z][y].length; x++) {
                System.out.print(next[z][y][x]);
            }
            System.out.println("");
        }
    }

}
   