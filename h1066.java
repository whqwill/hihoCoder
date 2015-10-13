import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by hwang on 13.10.15.
 */
public class h1066 {
    public static int find(int[] father, int i) {
        if (father[i] == i)
            return i;
        father[i] = find(father, father[i]);
        return father[i];
    }
    public static void main(String[] args) {
        Scanner cin = new Scanner(System.in);
        HashMap<String,Integer> map = new HashMap();
        int n = cin.nextInt();
        int num = 0;
        int[] father = new int[n];
        for (int i = 0; i < n; i++) {
            int op = cin.nextInt();
            String a = cin.next();
            String b = cin.next();
            cin.nextLine();
            int j = -1;
            int k = -1;
            if (map.containsKey(a))
                j = map.get(a);
            else {
                j = num;
                map.put(a,j);
                father[j] = j;
                num++;
            }
            if (map.containsKey(b))
                k = map.get(b);
            else {
                k = num;
                map.put(b,k);
                father[k] = k;
                num++;
            }
            k = find(father,k);
            j = find(father,j);
            if (op == 1) {
                if (k == j)
                    System.out.println("yes");
                else
                    System.out.println("no");
            }
            else
                father[k] = j;
        }
    }
}
