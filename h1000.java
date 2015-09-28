import java.util.Scanner;

/**
 * Created by hwang on 28.09.15.
 */
public class h1000 {
    public static void main(String[] agrs) {
        Scanner cin = new Scanner(System.in);
        while (cin.hasNext()) {
            String aOrb = cin.nextLine();
            String[] ab = aOrb.split(" ");
            int a = Integer.parseInt(ab[0]);
            int b = Integer.parseInt(ab[1]);
            System.out.println(a+b);
        }
    }
}
