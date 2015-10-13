import java.util.Scanner;

/**
 * Created by hwang on 13.10.15.
 */
public class h1037 {
    public static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        int[] f = new int[n];
        for (int i = 0; i < n; i++) {
            String[] line = cin.nextLine().split(" ");
            for (int j = line.length-1; j > 0; j--)
                f[j] = max(f[j],f[j-1])+Integer.parseInt(line[j]);
            f[0] += Integer.parseInt(line[0]);
        }
        int ans = 0;
        for (int i = 0; i < n; i++)
            ans = max(ans, f[i]);
        System.out.println(ans);
    }
}
