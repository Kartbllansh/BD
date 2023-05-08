package Base;

/**
 * Класс, отвечающий за голову дракона
 */
public class DragonHead {
    private Double size; //Поле не может быть null
    private Integer eyesCount; //Поле не может быть null
    private Long toothCount; //Поле может быть null

    /**
     * Конструктор со всеми полями класса DragonHead
     *
     * @param size       the size
     * @param eyesCount  the eyes count
     * @param toothCount the tooth count
     */
    public DragonHead(Double size, Integer eyesCount, Long toothCount) {
        this.eyesCount = eyesCount;
        this.size = size;
        this.toothCount = toothCount;
    }

    /**
     * Пустой конструктор
     */
    public DragonHead() {

    }

    @Override
    public String toString(){
    return "DragonHead:" +
            "Eyes count =" + eyesCount +
            ", size =" + size+
            ", Tooth count =" + toothCount;
    }

    /**
     * Gets size.
     *
     * @return the size
     */
    public Double getSize() {
        return size;
    }

    /**
     * Sets size.
     *
     * @param size the size
     */
    public void setSize(Double size) {
        this.size = size;
    }

    /**
     * Gets eyes count.
     *
     * @return the eyes count
     */
    public Integer getEyesCount() {
        return eyesCount;
    }

    /**
     * Sets eyes count.
     *
     * @param eyesCount the eyes count
     */
    public void setEyesCount(Integer eyesCount) {
        this.eyesCount = eyesCount;
    }

    /**
     * Gets tooth count.
     *
     * @return the tooth count
     */
    public Long getToothCount() {
        return toothCount;
    }

    /**
     * Sets tooth count.
     *
     * @param toothCount the tooth count
     */
    public void setToothCount(Long toothCount) {
        this.toothCount = toothCount;
    }
}
