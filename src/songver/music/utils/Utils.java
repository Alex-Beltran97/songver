package songver.music.utils;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utils {
    protected final Scanner SCANNER = new Scanner(System.in);
    private static final String NAME_REGEX = "^[\\p{L}\\s]+$";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String PASSWORD_REGEX = "^(?=.*[A-Z])(?=.*[a-z])(?=.*\\d)(?=.*[@$!%*?&]).{8,10}$";
    private static final Pattern NAME_PATTERN = Pattern.compile(NAME_REGEX, Pattern.UNICODE_CHARACTER_CLASS);
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);
    private static final Pattern PASSWORD_PATTERN = Pattern.compile(PASSWORD_REGEX);

    public String getText(String prompt) {
        System.out.println(prompt);
        return SCANNER.nextLine();
    }

    public int getOption(String prompt) {
        int option = 0;
        try {
            System.out.println(prompt);
            option = (int) SCANNER.nextInt();
        } catch (InputMismatchException e) {
            option = -1;
            System.out.println("🚫 Something went wrong while getting option: " + e.getMessage());
        }
        SCANNER.nextLine();
        return option;
    }

    public void getDivider() {
        System.out.println("------------------------------------------------------");
    }

    public boolean isEmpty(String value) {
        return value.isEmpty();
    }

    public boolean isValidName(String name) {
        Matcher matcher = NAME_PATTERN.matcher(name);
        return matcher.matches();
    }

    public boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }

    public boolean isValidPassword(String password) {
        Matcher matcher = PASSWORD_PATTERN.matcher(password.trim());
        return matcher.matches();
    }

    public boolean isValidConfirmedPassword(String password, String confirmedPassword) {
        return confirmedPassword.equals(password);
    }
}
