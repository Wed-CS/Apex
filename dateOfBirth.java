package apex;

/**
 *
 * @author Mashael Shaker
 */
public class dateOfBirth {

    public static final int MUHARRAM = 1;
    public static final int SAFAR = 2;
    public static final int RABIALAWWAL = 3;
    public static final int RABIALAKHAR = 4;
    public static final int JUMADAALAWWAL = 5;
    public static final int JUMADAALAKHIRAH = 6;
    public static final int RAJAB = 7;
    public static final int SHABAN = 8;
    public static final int RAMADAN = 9;
    public static final int SHAWAL = 10;
    public static final int DHULQADAH = 11;
    public static final int DHULHIJJAH = 12;

    private int day;
    private int month;
    private int year;

    public dateOfBirth() {
        this.day = 0;
        this.month = 0;
        this.year = 0;
    }

    public dateOfBirth(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public dateOfBirth copy() {
        dateOfBirth d = new dateOfBirth();
        d.day = day;
        d.month = month;
        d.year = year;
        return d;
    }

    public void setDay(int d) {
        day = d;
    }

    public void setMonth(int m) {
        month = m;
    }

    public void setYear(int y) {
        year = y;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    @Override
    public String toString() {
        return day + "/" + month + "/" + year;
    }
}
