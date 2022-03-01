package _4_HospitalDatabase;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    private static final String EMAIL_VALIDATION = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$";
    private static final String DATE_OF_BIRTH_VALIDATION = "^(3[01]|[12][0-9]|0[1-9])/(1[0-2]|0[1-9])/[0-9]{4}$";
    private static final String IMGUR_LINK_VALIDATION = "^https?:\\/\\/(\\w+\\.)?imgur.com\\/(\\w*\\d\\w*)+(\\.[a-zA-Z]{3})?$";

    public String validateName(String name) {
        if (name.length() < 2 || name.length() > 30) {
            throw new IllegalArgumentException("First name must be between 2 and 30 characters!");
        }
        if (name.trim().isEmpty()) {
            throw new IllegalArgumentException("First name cannot be empty!");
        }
        return name;
    }

    public boolean insuranceValidation(String answer) {
        if (answer.trim().isEmpty() || !answer.equals("YES") && !answer.equals("NO")) {
            throw new IllegalArgumentException("Invalid input!");
        }
        return answer.equals("YES");
    }

    private boolean validatePattern(String string, String pattern) {
        Pattern patternValidator = Pattern.compile(pattern);
        Matcher matcher = patternValidator.matcher(string);

        return matcher.find();
    }

    public String emailValidation(String email) {
        if (!validatePattern(email, EMAIL_VALIDATION)) {
            throw new IllegalArgumentException("Invalid Email!");
        }
        return email;
    }

    public String birthDateValidation(String date) {
        if (!validatePattern(date, DATE_OF_BIRTH_VALIDATION)) {
            throw new IllegalArgumentException("Invalid Date!");
        }
        return date;
    }

    public String pictureLinkValidation(String link) {
        if (!validatePattern(link, IMGUR_LINK_VALIDATION)) {
            throw new IllegalArgumentException("Invalid Link!");
        }
        return link;
    }
}
