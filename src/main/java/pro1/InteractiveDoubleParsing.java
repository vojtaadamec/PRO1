package pro1;

import java.util.Scanner;

public class InteractiveDoubleParsing {
    public static Scanner scanner = new Scanner(System.in);
    public static void main (String[] args)
    {
        while (true) {
            System.out.print("Zadejte číslo: ");
            String input = scanner.nextLine();

            try {
                double number = Double.parseDouble(input);
                System.out.println("Zadali jste číslo " + number);
            } catch (NumberFormatException e) {
                System.out.println("Zadali jste neplatný řetězec " + input);
            }
        }
    }






}
