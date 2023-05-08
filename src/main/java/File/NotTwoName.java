package File;

import Base.Dragon;

import java.util.LinkedList;
import java.util.TreeSet;

/**
 * Класс, запрещающий создание 2 драконов с одним именем
 */
public class NotTwoName {
    /**
     * Коллекция, благодаря которой проходит проверка на повторение
     */
    private final TreeSet<String> twoName = new TreeSet<>();

    /**
     * Метод проверяющий имена
     *
     * @param dragons the dragons
     */
    public void checkName(LinkedList<Dragon> dragons){
        for(int i=0; i<dragons.size(); i++) {
            Dragon check = dragons.get(i);
            String name1 = check.getName();
            if (twoName.contains(name1)) {
                dragons.remove(i);
                System.err.println("В программу поступила 2 дракона с одним именем ("+name1+") второй будет удален");
                System.out.print(">>");
            }
                else{
                    twoName.add(name1);
                }
            }
    }
    }
