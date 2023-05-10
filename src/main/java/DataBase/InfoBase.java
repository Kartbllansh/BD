package DataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Класс, позволяющий получить данные для подключения к базе данных
 */
public class InfoBase {
    /**
     * Поле, хранящее url подключения
     */
    private static String url;
    /**
     * Поле, хранящее логин для подключения к базе данных
     */
    private static String login;
    /**
     * Поле, хранящее пароль для подключения к базе данных
     */
    private static String passwd;

    /**
     * Метод, позволяющий установить url
     *
     * @param url the url
     */
    public static void setUrl(String url) {
        InfoBase.url = url;
    }

    /**
     * Sets login.
     *
     * @param login the login
     */
    public static void setLogin(String login) {
        InfoBase.login = login;
    }

    /**
     * Sets passwd.
     *
     * @param passwd the passwd
     */
    public static void setPasswd(String passwd) {
        InfoBase.passwd = passwd;
    }


    /**
     * Gets url.
     *
     * @return the url
     */
    public static String getUrl() {
        return url;
    }

    /**
     * Gets login.
     *
     * @return the login
     */
    public static String getLogin() {
        return login;
    }

    /**
     * Gets passwd.
     *
     * @return the passwd
     */
    public static String getPasswd() {
        return passwd;
    }

    static {
        Properties properties = new Properties();
        try {
            properties.load(new FileInputStream("sett.properties"));
            url = properties.getProperty("url");
            login = properties.getProperty("user");
            passwd = properties.getProperty("password");
        } catch (IOException ioException) {
            System.out.println(ioException.getMessage());
        }
    }
}
