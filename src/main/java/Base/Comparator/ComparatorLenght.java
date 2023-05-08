package Base.Comparator;

import Base.DragonType;

import java.util.Comparator;

/**
 *  Comparator - сравнивающий объекты типа type по длине слова
 */
public class ComparatorLenght implements Comparator<DragonType> {
    /**Метод, который проводит сравнение по типу, отталкиваясь от длины слов*/
    @Override
    public int compare(DragonType o1, DragonType o2) {
        return Integer.compare(o1.toString().length(), o2.toString().length());
    }
}
