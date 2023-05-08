package IO;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * Класс, помогающий общаться с пользователем
 */
public class IOUser {
    /**
     * The Scanner.
     */
    Scanner scanner;

    /**
     *Конструктор класса, в котором создается Scanner
     */
    public IOUser() {
        scanner = new Scanner(System.in, StandardCharsets.UTF_8);

    }

    /**
     * Конструктор класса
     *
     * @param scanner the scanner
     */
    public IOUser(Scanner scanner){
        this.scanner = scanner;
    }

    /**
     * Метод, считывающий строчку от пользователя
     *
     * @return the string
     */
    public String readCommand(){
        return scanner.nextLine();
    }

    /**
     * Метод, выводящий текст
     *
     * @param ok the ok
     */
    public void printText(String ok){
        System.out.println(ok);
    }

}
