package Base.Comparator;



import Base.Dragon;

import java.util.Comparator;

/**
 * Comparator сравнивающий драконов по возрасту и весу
 */
public class ComparatorAge implements Comparator<Dragon> {
    /**Метод, который проводит сравнение по возрасту и весу*/
    @Override
    public int compare(Dragon dragon1, Dragon dragon2) {
        if (!dragon1.getAge().equals(dragon2.getAge())) {
            return dragon1.getAge() - dragon2.getAge();
        } else {
            return dragon1.getWeight().compareTo(dragon2.getWeight());
        }
    }
}
