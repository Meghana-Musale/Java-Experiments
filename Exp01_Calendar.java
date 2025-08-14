// Calendar
public class Calendar {
    public static void main(String[] args) {
        int day = Integer.valueOf(args[0]);
        int month = Integer.valueOf(args[1]);
        int year = Integer.valueOf(args[2]);

        int[] monthDays = { 31, 28, 31, 30, 31, 30,
                            31, 31, 30, 31, 30, 31 };

        String[] weekDays = { "Monday", "Tuesday", "Wednesday", "Thursday",
                              "Friday", "Saturday", "Sunday" };

        int totalDays = 0;

        // Add days for full years using if-else and switch
        for (int i = 1900; i < year; i++) {
            boolean isLeap = false;

            if ((i % 4 == 0 && i % 100 != 0) || (i % 400 == 0)) {
                isLeap = true;
            }

            switch (isLeap ? 1 : 0) {
                case 1:
                    totalDays += 366;
                    break;
                case 0:
                    totalDays += 365;
                    break;
            }
        }

        // Add days for months before the given month
        for (int i = 0; i < month - 1; i++) {
            totalDays += monthDays[i];

            if (i == 1) { // February
                boolean isLeap = false;

                if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) {
                    isLeap = true;
                }

                switch (isLeap ? 1 : 0) {
                    case 1:
                        totalDays += 1;
                        break;
                }
            }
        }

        totalDays += day - 1; // Add days of current month

        int choice = totalDays % 7;

        String dayOfWeek;
        switch (choice) {
            case 0: dayOfWeek = "Monday"; break;
            case 1: dayOfWeek = "Tuesday"; break;
            case 2: dayOfWeek = "Wednesday"; break;
            case 3: dayOfWeek = "Thursday"; break;
            case 4: dayOfWeek = "Friday"; break;
            case 5: dayOfWeek = "Saturday"; break;
            case 6: dayOfWeek = "Sunday"; break;
            default: dayOfWeek = "Unknown"; break;
        }

        System.out.println("The Day for given date is " + dayOfWeek);
    }
}
