package my.projects.Games.Console.GuessTheNumber;
import java.util.Scanner;

public class GuessTheNumber {

    public static void main(String[] args) {
        new GuessTheNumber();
    }

    private GuessTheNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        int range = scanner.nextInt();
        int number = (int) (Math.random() * range);
        System.out.println("Угадайте число от 0 до " + range);
        while (true) {
            int input_number = scanner.nextInt();
            if (input_number == number) {
                System.out.println("Вы угадали");
                break;
            } else if (input_number > number) {
                System.out.println("Загаданное число меньше");
            } else {
                System.out.println("Загаданное число больше");
            }
        }
        scanner.close();
    }
}