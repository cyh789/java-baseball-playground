package ValidationUtils;

public class ValidationUtils {

    public static final int MIN_NO = 1;
    public static final int MAX_NO = 9;

    public static boolean validNo(int no) {
        return no >= MIN_NO && no <= MAX_NO;
    }

    public static boolean validSizs(int no) {;
        return no >= 100 && no <= 999;
    }

}
