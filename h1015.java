import java.util.Scanner;

/**
 * Created by hwang on 13.10.15.
 */
public class h1015 {
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < n; i++) {
            String strA = cin.nextLine();
            String strB = cin.nextLine();
            int[] prePos = new int[strA.length()+1];
            for (int j = 2; j <= strA.length(); j++) {
                int k = j-1;
                while (true) {
                    if (strA.charAt(j-1) == strA.charAt(prePos[k]+1-1)) {
                        prePos[j] = prePos[k]+1;
                        break;
                    }
                    if (prePos[k] == 0) {
                        prePos[j] = 0;
                        break;
                    }
                    k = prePos[k];
                }
            }
            int j = 1;
            int k = 1;
            int ans = 0;
            while (k <= strB.length()) {
                if (j == strA.length()+1) {
                    ans++;
                    j = prePos[j-1]+1;
                    continue;
                }
                if (strA.charAt(j-1) == strB.charAt(k-1)) {
                    j++;
                    k++;
                    continue;
                }
                if (j == 1) {
                    k++;
                    continue;
                }
                j = prePos[j-1]+1;
            }
            if (j == strA.length()+1)
                ans++;
            System.out.println(ans);
        }
    }
}