package Command;

import DataBase.Users;

public class CheckUser {
    public static boolean checkUsers(){
        return Users.getCurrentUser() != null;
    }
}
