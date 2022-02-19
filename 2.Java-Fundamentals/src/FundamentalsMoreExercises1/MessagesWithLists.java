package FundamentalsMoreExercises1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class MessagesWithLists {
    public static void main(String[] args) {
        Scanner Input = new Scanner(System.in);
        String LettersAtString = " , ,abc,def,ghi,jkl,mno,pqrs,tuv,wxyz";
        List<String> Letters = Arrays.stream(LettersAtString.split(",")).collect(Collectors.toList());

        int N = Integer.parseInt(Input.nextLine());
        for(int i=1;i<=N;i++){
            String Number=Input.nextLine();
            int Index = Number.charAt(0)-48;
            int PositionOfLetter = Number.length()-1;

            String LetterOrSpace = String.valueOf(Letters.get(Index).charAt(PositionOfLetter));
            System.out.printf("%s",LetterOrSpace);

        }
    }
}
