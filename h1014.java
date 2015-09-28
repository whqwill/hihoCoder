import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by hwang on 28.09.15.
 */
public class h1014 {
    public static class Trie {
        int count = 1;
        HashMap<Character, Trie> map = new HashMap();
    }

    public static void insertWord(String word, HashMap<Character, Trie> vocab) {
        if (word.length() == 0)
            return;
        if (!vocab.containsKey(word.charAt(0)))
            vocab.put(word.charAt(0), new Trie());
        else
            vocab.get(word.charAt(0)).count++;
        insertWord(word.substring(1), vocab.get(word.charAt(0)).map);
    }

    public static int findPrefix(String word, HashMap<Character, Trie> vocab) {
        if (!vocab.containsKey(word.charAt(0)))
            return 0;
        if (word.length() == 1)
            return vocab.get(word.charAt(0)).count;
        return findPrefix(word.substring(1), vocab.get(word.charAt(0)).map);
    }
    public static void main(String[] agrs) {
        Scanner cin = new Scanner(System.in);
        HashMap<Character, Trie> vocab = new HashMap();

        int n = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < n; i++)
            insertWord(cin.nextLine(), vocab);

        n = cin.nextInt();
        cin.nextLine();
        for (int i = 0; i < n; i++)
            System.out.println(findPrefix(cin.nextLine(), vocab));
    }
}
