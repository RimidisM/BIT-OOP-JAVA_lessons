package racegamev0;

/**
 *
 * @author rimid
 */
public class RaceGameV0 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        char[] cars = {'A', 'B', 'C'};
        int[] dist = {0, 0, 0};

        boolean end = true;

        while (end == true) {

            for (int i = 0; i < cars.length; i++) {
                int kiek = (int) (Math.random() * ((30 - 0) + 1)) + 0;

                dist[i] += kiek;

                if (dist[i] >= 200) {
                    end = false;
                    System.out.println("!!!!!!!!!Laimejo automobilis " + cars[i]);
                    break;
                }
            }
            sort(cars, dist);
            print(cars, dist);
        }

    }

    //Method print cars
    public static void print(char[] cars, int[] dist) {
        for (int i = 0; i < dist.length; i++) {
            System.out.println(cars[i] + " - " + dist[i]);
        }
        System.out.println("/==============================================/");
    }

    //Method sort cars
    public static void sort(char[] c, int[] d) {
        for (int i = 0; i < d.length - 1; i++) {
            for (int j = i + 1; j < d.length; j++) {
                if (d[j] > d[i]) {
                    int temp = d[i];
                    d[i] = d[j];
                    d[j] = temp;

                    char temp1 = c[i];
                    c[i] = c[j];
                    c[j] = temp1;
                }
            }
        }
    }
}

/*
ND
masinu lenktynes
char [] masinuPavadinimai = {'a', 'b', 'c'};
int[] nuvaziuotasKelias = {0, 0, 0};
padaryti cikla, ciklo metu masina gali pajudeti nuo 0 iki 30
 Kiekvieno ciklo iteracijos pabaigoje atspauzdinti sarasa 
su masinu pavadinimu ir ju nuvaziuotu keliu, surusiuota pagal nuvaziuota kelia
 Ciklas turi baiktis kai bent viena masian nuvaziavo 200 atstuma
 Atstumas random imamas nuo 0 iki 30
 */
