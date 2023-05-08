package DataBase;

import java.sql.*;
import java.util.LinkedList;

public class MainDataBase {
    private static Connection connection;

    //Класс Connection в Java используется для установления соединения с базами данных.
    private static void getConnection() {
        try {
            connection = DriverManager.getConnection(InfoBase.getUrl(), InfoBase.getLogin(), InfoBase.getPasswd());
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //метод, выполняет запрос без измененния данных
    public static void requestSQLWithout(String request) {
        getConnection();
        try {
            connection.createStatement().execute(request);
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    //метод, выполняет запрос с измененния данных
    public static ResultSet requestSQLWith(String request, String... values) {
        getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(request);
            for (int i = 0; i < values.length; ++i) {
                preparedStatement.setString(i + 1, values[i]);
            }
            return preparedStatement.executeQuery();
        } catch (SQLException e) {
            return null;
        } finally {
            try {
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }


    public static void CreateTables() {
        getConnection();
        requestSQLWithout(Request.CREATEDRAGONS.getStringValue());
        requestSQLWithout(Request.CREATEDUSERS.getStringValue());
        requestSQLWithout(Request.CREATEDSEQUENCE.getStringValue());
    }

    public static LinkedList<String> compareLogin() {
        getConnection();
        LinkedList<String> loginList = new LinkedList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Request.SEARCHLOGIN.getStringValue());
            while (resultSet.next()) {

                loginList.add(resultSet.getString("login"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return loginList;
    }
    public void logOut(){

    }

    public static boolean checkLogin(String login) {
        LinkedList<String> linkedList = compareLogin();
        boolean foundMatch = false;

        for (String element : linkedList) {  // проходим по всем элементам LinkedList<String>
            if (element.equals(login)) {  // сравниваем строку с текущим элементом
                foundMatch = true;
                break;
            }
        }
        return foundMatch;
    }
}

