package DataBase;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class InfoBase {
    private static String url;
    private static String login;
    private static String passwd;

    public static void setUrl(String url) {
        InfoBase.url = url;
    }

    public static void setLogin(String login) {
        InfoBase.login = login;
    }

    public static void setPasswd(String passwd) {
        InfoBase.passwd = passwd;
    }



    public static String getUrl() {
        return url;
    }

    public static String getLogin() {
        return login;
    }

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
