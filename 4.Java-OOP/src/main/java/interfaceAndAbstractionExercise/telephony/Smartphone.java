package interfaceAndAbstractionExercise.telephony;

import java.util.List;

public class Smartphone implements Callable, Browsable {
    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String call() {
        StringBuilder sb = new StringBuilder();
        for (String number : numbers) {
            if (hasDigits(number)) {
                sb.append("Calling... ").append(number).append("\n");
            } else {
                sb.append("Invalid number!").append("\n");
            }
        }
        return sb.toString().trim();
    }

    @Override
    public String browse() {
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            if (doesNotHaveDigits(url)) {
                sb.append("Browsing: ").append(url).append("!").append("\n");
            } else {
                sb.append("Invalid URL!").append("\n");
            }
        }
        return sb.toString().trim();
    }

    private static boolean doesNotHaveDigits(String url) {
        boolean isOk = true;
        for (int i = 0; i < url.length(); i++) {
            if (Character.isDigit(url.charAt(i))) {
                isOk = false;
                break;
            }
        }
        return isOk;
    }


    private static boolean hasDigits(String number) {
        boolean isOk = true;
        for (int i = 0; i < number.length(); i++) {
            if (!Character.isDigit(number.charAt(i))) {
                isOk = false;
                break;
            }
        }
        return isOk;
    }
}
