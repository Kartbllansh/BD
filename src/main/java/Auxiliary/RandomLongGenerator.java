package Auxiliary;

import java.util.TreeSet;
import java.util.UUID;

/**
 * Класс, генерирующий рандомные числа для ID
 */
public class RandomLongGenerator {
    /**
     * Коллекция, помогающая избежать повторений
     */
    static TreeSet<Long> set = new TreeSet<>();

    /**
     * Метод, генерирующий рандомные число Long
     * @see UUID#randomUUID()
     * @return the long
     */
    public  static Long generId(){
        boolean r = false;
        UUID uuid = UUID.randomUUID();
        Long randomLong = uuid.getMostSignificantBits() & Long.MAX_VALUE;
        while (!r) {
            if (!set.contains(randomLong)) {
                set.add(randomLong);
                r = true;
            } else {
                try {
                    randomLong ++;

                } catch (NullPointerException e) {
                    System.out.println("Exception");
                }

            }
        }
        return randomLong;
    }
}