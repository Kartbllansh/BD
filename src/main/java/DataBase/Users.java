package DataBase;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Scanner;


/**
 * Класс, работающий с пользователями
 */
public class Users {
    /**
     * Метод, устанавливающий пользователя работающего с коллекцией в данный момент
     *
     * @param currentUser the current user
     */
    public static void setCurrentUser(String currentUser) {
        Users.currentUser = currentUser;
    }

    /**
     * Поле, хранящее ссылку на объект
     */
    public static ZonedDateTime time;
    /**
     * Поле, хранящее информацию о пользователе
     */
    private static String currentUser = null;

    /**
     * Gets current user.
     *
     * @return the current user
     */
    public static String getCurrentUser() {
        return currentUser;
    }


    /**
     * Метод, запускающий авторизацию в программе
     */
    public void startAuthentication(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя");
        String login = scanner.nextLine();
        System.out.println(MainDataBase.compareLogin());
        boolean decision = MainDataBase.checkLogin(login);
        if(decision){
            System.out.println("Пользователь с таким логином существует");
            System.out.println("Войдите в аккаунт "+login);
            enter(login, scanner);


        } else {
            System.out.println("Пользователя с таким логином не существует");
            System.out.println("Зарегистрируйте аккаунт "+login);
            registration(login, scanner);
        }

    }

    /**
     * Метод, позволяющий войти в аккаунт
     *
     * @param login   the login
     * @param scanner the scanner
     */
    public void enter(String login, Scanner scanner){

        try {
            int count = 5;

        while(count > 0){
            System.out.println("Введите пароль");
            MessageDigest md = MessageDigest.getInstance("SHA-512");
            ResultSet resultSetSalt = MainDataBase.requestSQLWith("SELECT salt FROM USERS WHERE login = ?", login);
            assert resultSetSalt != null;
            resultSetSalt.next();
            String salt = resultSetSalt.getString(1);
            ResultSet resultSetHash = MainDataBase.requestSQLWith("SELECT hash FROM USERS WHERE login = ?", login);
            assert resultSetHash != null;
            resultSetHash.next();
            byte[] hash = md.digest(("*63&^mVLC(#" + scanner.nextLine().trim() + salt).getBytes(StandardCharsets.UTF_8));
            if(Arrays.toString(hash).equals(resultSetHash.getString(1))){
                System.out.println("Добро пожаловать, "+login);
                currentUser = login;
                time = ZonedDateTime.now();
                count = -10;
            } else {
                System.out.println("Неверный пароль. Осталось попыток: "+(--count));
            }
        }
        } catch (SQLException | NullPointerException | NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }


    }

    /**
     * Метод, позволяющий зарегестрировать аккаунт
     *
     * @param login   the login
     * @param scanner the scanner
     */
    public void registration(String login, Scanner scanner){
        String passwd = null;
        int count =5;
        while (count>0) {
            System.out.println("Введите пароль");
            passwd = scanner.nextLine().trim();
            System.out.println("Введите пароль еще раз");
            String passwdd = scanner.nextLine().trim();
            if(!passwdd.equals(passwd)){
                System.out.println("Пароли не совпадают. Повторите попытку. Их осталось "+(--count));
            } else {
                count = -10;
            }
        }
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        String salt = SaltGenerate.saltGetter();
        byte[] hash = md.digest(("*63&^mVLC(#" + passwd + salt).getBytes(StandardCharsets.UTF_8));
        //MainDataBase.requestSQLWithout("INSERT INTO USERS (login, hash, salt) VALUES (?, ?, ?)", login, Arrays.toString(hash), salt);
        MainDataBase.requestSQLWithout("INSERT INTO USERS (login, hash, salt) VALUES ('" + login + "', '" + Arrays.toString(hash) + "', '" + salt + "')");
        System.out.println("Вы успешно прошли регистрацию");
        currentUser = login;

    }

}
