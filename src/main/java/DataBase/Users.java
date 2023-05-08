package DataBase;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Scanner;


public class Users {
    public static void setCurrentUser(String currentUser) {
        Users.currentUser = currentUser;
    }

    private static String currentUser = null;
    public static String getCurrentUser() {
        return currentUser;
    }


    public void startAuthentication(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите имя пользователя");
        String login = scanner.nextLine();
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

    public void enter(String login, Scanner scanner){

        try {
            int count = 5;

        while(count > 0){
            System.out.println("Введите пароль");
            MessageDigest md = MessageDigest.getInstance("SHA-1");
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
                count = -10;
            } else {
                System.out.println("Неверный пароль. Осталось попыток: "+(--count));
            }
        }
        } catch (SQLException | NullPointerException | NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }


    }
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
            md = MessageDigest.getInstance("SHA-224");
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
        String salt = SaltGenerate.saltGetter();
        byte[] hash = md.digest(("*63&^mVLC(#" + passwd + salt).getBytes(StandardCharsets.UTF_8));
        MainDataBase.requestSQLWith("INSERT INTO USERS (login, hash, salt, dataAut) VALUES (?, ?, ?, ?)", login, Arrays.toString(hash), salt, LocalDate.now().toString());
        System.out.println("Вы успешно прошли регистрацию");
        currentUser = login;

    }

}
