import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by hwang on 28.09.15.
 */
public class h1148 {
    public static class Date {
        int day;
        int month;
        int year;
        public Date(int day, int month, int year) {
            this.day = day;
            this.month = month;
            this.year = year;
        }
    }

    public static boolean isLeapYear(int y) {
        return y % 400 == 0 || (y % 100 != 0 && y % 4 == 0);
    }

    public static boolean earlier(Date date1, Date date2) {
        if (date1.year != date2.year)
            return date1.year < date2.year;
        if (date1.month != date2.month)
            return date1.month < date2.month;
        return date1.day < date2.day;
    }

    public static int calulate(Date date) {
        int num = date.year/4-date.year/100+date.year/400;
        if (earlier(date, new Date(29,2,date.year)) && isLeapYear(date.year))
            num--;
        return num;
    }

    public static void main(String[] agrs) {
        Scanner cin = new Scanner(System.in);
        int n = cin.nextInt();
        HashMap<String, Integer> months = new HashMap();
        int m = 0;
        for (String key : new String[] {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November" , "December"})
            months.put(key, ++m);
        for (int i = 1; i <= n; i++) {

            m = months.get(cin.next());
            String tmp = cin.next();
            int d = Integer.parseInt(tmp.substring(0, tmp.length() - 1));
            int y = cin.nextInt();
            Date date1 = new Date(d,m,y);

            m = months.get(cin.next());
            tmp = cin.next();
            d = Integer.parseInt(tmp.substring(0, tmp.length() - 1));
            y = cin.nextInt();
            Date date2 = new Date(d,m,y);

            int ans = calulate(date2)-calulate(date1);
            if (isLeapYear(date1.year) && date1.month==2 && date1.day==29)
                ans++;
            System.out.println("Case #"+i+": "+ans);
        }
    }
}
