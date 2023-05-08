package IO;

import Base.*;
import DataBase.MainDataBase;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

/**
 * Класс позволяющий заменять поля у драконов
 */
public class UserDragon {

    public static long generId() {
        long newId = 0;
        ResultSet resultSet = MainDataBase.requestSQLWith("SELECT nextval(?)", "DRADONSEQ");
        try {
            assert resultSet != null;
            resultSet.next();
            newId = resultSet.getLong(1);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return newId;
    }
    /**
     * Метод, который может заменить имя
     *
     * @param dragon the dragon
     * @param s      the s
     */
    public void addName(Dragon dragon, Scanner s){
        System.out.println("Введите имя дракона");
        boolean otvet = false;
        while (!otvet) {
                String newname = s.nextLine().trim();
                if (newname.matches("[-a-zA-Zа-яА-ЯЁё]+")) {
                    dragon.setName(newname);
                    otvet = true;
                } else {
                    System.out.println("Неправильный формат");
                }

        }
    }


    /**
     * Метод, который может заменить возраст
     *
     * @param s      the s
     * @param dragon the dragon
     */
    public void addAge(Scanner s, Dragon dragon){
        boolean otvet = false;
        while (!otvet) {
            if(s.hasNextInt()) {
                int newage = s.nextInt();

                if (newage > 0) {
                    dragon.setAge(newage);
                    otvet = true;
                } else {
                    System.out.println("Число меньше нуля нельзя вводить");
                }
            } else {
                System.out.println("Введите число");
                s.next();
            }
        }
    }

    /**
     * Метод, который может заменить вес
     *
     * @param s      the s
     * @param dragon the dragon
     */
    public void addWeight(Scanner s, Dragon dragon){
        boolean otvet = false;
        while (!otvet) {
            if (s.hasNextLong()){
                long newwei = s.nextLong();
                if (newwei > 0) {
                    dragon.setWeight(newwei);
                    otvet = true;
                } else {
                    System.out.println("Нельзя ввести отрицательное число");
                }
            } else {
                System.out.println("Введите число");
                s.next();
            }
        }
    }

    /**
     * Метод, который может заменить цвет
     *
     * @param s      the s
     * @param dragon the dragon
     */
    public void addColor(Scanner s, Dragon dragon){
        boolean otvet = false;
        while (!otvet) {

                String a = s.nextLine().trim().toUpperCase();
            if (!a.matches("[ -]*")) {
                Boolean b = a.equals("WHITE");
                Boolean c = a.equals("ORANGE");
                Boolean d = a.equals("YELLOW");
                if (b | c | d) {
                    Color newcolor = Color.valueOf(a);
                    dragon.setColor(newcolor);
                    otvet = true;
                } else {
                    System.out.println("Вы ввели неправильно цвет");
                    //System.exit(0);
                }
            }
        }
    }

    /**
     * Метод, который может заменить тип
     *
     * @param s      the s
     * @param dragon the dragon
     */
    public void addType(Scanner s, Dragon dragon){
        boolean otvet = false;
        while (!otvet) {

                String f = s.nextLine().trim().toUpperCase();
            if (!f.matches("[ -]*")) {
                Boolean e = f.equals("WATER");
                Boolean q = f.equals("UNDERGROUND");
                Boolean o = f.equals("AIR");
                if (e | q | o) {
                    DragonType newtype = DragonType.valueOf(f);
                    dragon.setType(newtype);
                    otvet = true;
                } else {
                    System.out.println("Вы ввели неправильное тип");
                    // System.exit(0);
                }
            }
        }
    }

    /**
     * Метод, который может заменить размер
     *
     * @param s      the s
     * @param dragon the dragon
     */
    public void addSize(Scanner s, Dragon dragon){
       DragonHead dragonHead = new DragonHead();
        boolean otvet = false;
        while (!otvet) {
            if (s.hasNextDouble()) {
                double sizenew = s.nextDouble();
                if(sizenew>0) {
                    dragonHead.setSize(sizenew);
                    dragon.setHead(dragonHead);
                    otvet = true;
                } else {
                    System.out.println("Нельзя ввести отрицательное число");
                }
            } else {
                System.out.println("Введите число");
                s.next();
            }
        }
    }

    /**
     * Метод, который может заменить количество зубов
     *
     * @param s      the s
     * @param dragon the dragon
     */
    public void addTooth(Scanner s, Dragon dragon){
        DragonHead dragonHead = dragon.getHead();
        boolean otvet = false;
        while (!otvet) {
            if (s.hasNextLong()) {
                long toothnew = s.nextLong();
                if(toothnew>=0) {
                    dragonHead.setToothCount(toothnew);
                    otvet = true;
                } else {
                    System.out.println("Нельзя ввести отрицательное число");
                }
            } else {
                System.out.println("Введите число");
                s.next();
            }
        }
    }

    /**
     * Метод, который может заменить количество глаз
     *
     * @param s      the s
     * @param dragon the dragon
     */
    public void addEyes(Scanner s, Dragon dragon){
        DragonHead dragonHead = dragon.getHead();
        boolean otvet = false;
        while (!otvet) {
            if (s.hasNextInt()) {
                int eyesnew = s.nextInt();
                if(eyesnew>0) {
                    dragonHead.setEyesCount(eyesnew);
                    otvet = true;
                } else {
                    System.out.println("Нельзя ввести отрицательное число");
                }
            } else {
                System.out.println("Введите число");
                s.next();
            }
        }
    }

    /**
     * Метод, который может заменить координату Х
     *
     * @param s      the s
     * @param dragon the dragon
     */
    public void addCoordinatesX(Scanner s, Dragon dragon){

        Coordinates coordinates = new Coordinates();
        boolean otvet = false;
        while (!otvet) {
            if (s.hasNextFloat()) {
                float xnew = s.nextFloat();
                if(xnew > -474 && xnew != 0) {
                    coordinates.setX(xnew);
                    dragon.setCoordinates(coordinates);
                    otvet = true;
                } else {
                    System.out.println("Введите корректное значение");
                }
            } else {
                System.out.println("Введите число");
                s.next();
            }
        }
    }

    /**
     * Метод, который может заменить координату Y
     *
     * @param s      the s
     * @param dragon the dragon
     */
    public void addCoordinatesY(Scanner s, Dragon dragon){
        Coordinates coordinates = dragon.getCoordinates();
        boolean otvet = false;
        while (!otvet) {
            if (s.hasNextFloat()) {
                float ynew = s.nextFloat();
                if(ynew > -474 && ynew != 0) {
                    coordinates.setY(ynew);
                    otvet = true;
                } else {
                    System.out.println("Введите корректное значение");
                }
            } else {
                System.out.println("Введите число");
                s.next();
            }
        }
    }

}
