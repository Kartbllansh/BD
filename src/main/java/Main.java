
import Command.InvokerCommand;
import DataBase.InfoBase;
import DataBase.MainDataBase;
import DataBase.Users;
import File.CollectionManager;
import File.Home;
import IO.IOUser;

import java.util.NoSuchElementException;

/**
 * Класс Main, который запускает программу
 */
public class Main {

    public static void main(String[] args) {
        Home home = new Home();
        home.start();
    }
}