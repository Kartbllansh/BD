package File;

import Auxiliary.RandomLongGenerator;
import Base.Dragon;
import IO.AllAdd;

import java.util.LinkedList;


/**
 * Класс, который устанавливает ID
 */
public class VotTvoyId {




    /**
     * Метод, устанавливающий ID
     */
    public  void votIdBad(LinkedList<Dragon> dragons) {
        for (int i = 0; i < dragons.size(); i++) {
            dragons.get(i).setId((long)i+1);
        }
    }
    /**
     * Метод, который устанавливает ID
     * @see RandomLongGenerator#generId()
     * @param dragons the dragons
     */
    public static void votId(LinkedList<Dragon> dragons){
        for(Dragon dragon : dragons){
            Long idxdx = RandomLongGenerator.generId();
            dragon.setId(idxdx);
        }
    }

    /**
     * Метод, который устанавливает ID
     *      * @see RandomLongGenerator#generId()
     *
     * @param dragon the dragon
     */
    public static void votDragon(Dragon dragon){
        Long idxdx = RandomLongGenerator.generId();
        dragon.setId(idxdx);
    }
    /**
     * Метод, устанавливающий правильный id после изменения коллекции
     */
    public LinkedList<Long> checkId(LinkedList<Dragon> dragons){
        LinkedList<Long> id = new LinkedList<>();
        int num = dragons.size()+1;
        for (int i = 1; i <= num; i++) {
            id.add((long) i);
        }
        return id;
    }
}