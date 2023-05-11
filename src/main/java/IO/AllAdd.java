package IO;

import Auxiliary.RandomDragon;
import Base.Color;
import Base.Dragon;
import Base.DragonType;
import File.VotTvoyId;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

/**
 * Класс, который создает нового дракона
 */
public class AllAdd {
    /**
     * Поле, хранящее ссылку на объект класса UserDragon..
     */
    UserDragon userDragon;

    /**
     * Конструктор класса
     *
     * @param userDragon the user dragon
     */
    public AllAdd(UserDragon userDragon){
        this.userDragon = userDragon;
    }

    /**
     * Метод, который создает дракона
     * @see UserDragon#addAge(Scanner, Dragon)
     *       @see UserDragon#addColor(Scanner, Dragon)
     *       @see UserDragon#addEyes(Scanner, Dragon)
     *      @see UserDragon#addCoordinatesX(Scanner, Dragon)
     *      @see UserDragon#addName(Dragon, Scanner)
     *       @see UserDragon#addCoordinatesY(Scanner, Dragon)
     *       @see UserDragon#addTooth(Scanner, Dragon)
     *       @see UserDragon#addType(Scanner, Dragon)
     *       @see UserDragon#addWeight(Scanner, Dragon)
     *       @see UserDragon#addSize(Scanner, Dragon)
     * @return the dragon
     */
    public Dragon groupMethod(){
        Dragon change = new Dragon();
        change.setCreationDate(ZonedDateTime.now());
        Scanner update = new Scanner(System.in);
        VotTvoyId.votDragon(change);
        //change.setId(UserDragon.generId());
        userDragon.addName(change, update);
        String random = change.getName();
        if(Objects.equals(random, "random")){
            return RandomDragon.doRandomDragon();
        }
        System.out.println("Введите возраст для Дракона");
        userDragon.addAge(update, change);
        System.out.println("Введите вec Дракона");
        userDragon.addWeight(update, change);
        System.out.println("Введите цвет вашего Дракона ");
        System.out.println("Выберите из:" + Arrays.toString(Color.values())+" можно ввести нижним регистром" );
        userDragon.addColor(update, change);
        System.out.println("Введите тип Дракона");
        System.out.println("Выберите из:"+Arrays.toString(DragonType.values())+ "можно ввести нижним регистром");
        userDragon.addType(update, change);
        System.out.println("Введите размер дракона");
        userDragon.addSize(update, change);
        System.out.println("Введите количество глаз");
        userDragon.addEyes(update, change);
        System.out.println("Введите количество зубов");
        userDragon.addTooth(update, change);
        System.out.println("Введите координату Х");
        userDragon.addCoordinatesX(update, change);
        System.out.println("Введите координату Y");
        userDragon.addCoordinatesY(update, change);
        return change;
    }
}
