package Base;

/**
 * The type Coordinates - класс отвечающий за координаты драконов
 */
public class Coordinates {
    private Float x; //Значение поля должно быть больше -474, Поле не может быть null
    private float y;

    /**
     * Instantiates a new Coordinates.
     *
     * @param x the x - координата указывающая положение по х
     * @param y the y - координата указывающая положение по y
     */
    public Coordinates(Float x, float y){
    this.setX(x);
    this.y = y;
}

    /**
     * Instantiates a new Coordinates - пустой
     */
    public Coordinates() {

    }

    @Override
public String toString(){
    return "Coordinates: " +
            "x="+x +
            ", y="+y;
}

    /**
     * Метод возвращающий значение по х
     *
     * @return the x
     */
    public Float getX() {
        return x;
    }

    /**
     * Метод возвращающий значение по y
     *
     * @return the y
     */
    public float getY() {
        return y;
    }

    /**
     * Устанавливает значение по х
     *
     * @param x the x
     */
    public void setX(Float x) {
        this.x = x;
    }


    /**
     * Устанавливает значение по y
     *
     * @param y the y
     */
    public void setY(float y) {
        this.y = y;
    }
}
