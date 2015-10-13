import java.util.Scanner;

/**
 * Created by hwang on 13.10.15.
 */
public class h1043 {
    public static int max(int a, int b) {
        if (a > b)
            return a;
        else
            return b;
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        int v = cin.nextInt();
        int[] f = new int[v+1];
        for (int i = 0; i < n; i++) {
            int weight = cin.nextInt();
            int value = cin.nextInt();
            for (int j = weight; j <= v; j++)
                if (j == weight || f[j-weight] != 0)
                    f[j] = max(f[j],f[j-weight]+value);
        }
        int ans = 0;
        for (int j = 0; j <= v; j++)
            ans = max(ans,f[j]);
        System.out.println(ans);
    }
}
