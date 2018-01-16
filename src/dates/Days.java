package dates;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Days {
	String[] recurringTask(String firstDate, int k, String[] daysOfTheWeek, int n) {
		final SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Set<String> days = new HashSet<>();
		for(String d : daysOfTheWeek) {
			days.add(d);
		}
		String[] ans = new String[n];
		int cur = 0;
		int ptr = 0;
		try {
			while (ptr < n) {
				if (ptr == 0) {
					ans[ptr++] = firstDate;
					cur++;
				} else if (cur < daysOfTheWeek.length) {
					ans[ptr] = getDate(ans[ptr-1], days);
					ptr++;
					cur++;
				} else {
					int t = cur % daysOfTheWeek.length;
					int q = cur / daysOfTheWeek.length;
					Date date = format.parse(ans[t]);
					Calendar calendar = Calendar.getInstance();
					calendar.setTime(date);
					calendar.add(Calendar.DAY_OF_YEAR, 7 * k * q);
					ans[ptr++] = format.format(calendar.getTime());
					cur++;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ans;
	}

	String getDate(String fromDate, Set<String> req) throws Exception {
		String[] days = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday" };
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = format.parse(fromDate);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		String cur = days[calendar.get(Calendar.DAY_OF_WEEK)-1];
		for (int i = 1; i < 7; i++) {
			calendar.add(Calendar.DAY_OF_YEAR, 1);
			int x = calendar.get(Calendar.DAY_OF_WEEK);
			String day = days[x - 1]; 
			if (!cur.equals(day) && req.contains(day)) {
				return format.format(calendar.getTime());
			}
		}
		return null;
	}

	public static void main(String[] args) {
		Days obj = new Days();
		Scanner sc = new Scanner(System.in);
		String fd = sc.nextLine();
		int k = sc.nextInt();
		sc.nextLine();
		String days = sc.nextLine();
		int n = sc.nextInt();
		String[] ans = obj.recurringTask(fd, k, days.split(","), n);
		for (String a : ans) {
			System.out.println(a);
		}
	}
}
