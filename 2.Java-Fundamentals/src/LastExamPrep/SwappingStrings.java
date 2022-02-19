package LastExamPrep;

public class SwappingStrings {
    public static void main(String[] args) {
        String a = "Yes";
        String b = "Nope";
        System.out.println("Before swap:" + a + " " + b);
        a = a + b;
        b = a.substring(0, a.length()-b.length());
        a = a.substring(b.length());
        System.out.println("After swap:" + a + " " + b);
    }
}
