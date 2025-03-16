package pro1;

import java.util.Scanner;

public class InteractiveFractionParsing {
        public static Scanner scanner = new Scanner(System.in);
        public static void main (String[] args)
        {
            while (true) {
                System.out.print("Zadejte zlomek: ");
                String input = scanner.nextLine();

                try {
                    Fraction number = Fraction.parse(input);
                    System.out.println("Zadali jste zlomek " + number);
                } catch (NumberFormatException e) {
                    System.out.println("Zadali jste neplatný řetězec " + input);
                }
            }
        }
}
