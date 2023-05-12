package Base;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Важнейший класс, отвечающий за создание объектов класса Dragon
 */
public class Dragon  {

    private Long id; //Поле не может быть null, Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private ZonedDateTime creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Integer age; //Значение поля должно быть больше 0, Поле может быть null
    private Long weight; //Значение поля должно быть больше 0, Поле не может быть null
    private Color color; //Поле не может быть null
    private DragonType type; //Поле не может быть null
    private DragonHead head;
    private String creator;

    /**
     * Конструктор со всеми полями класса Dragon
     * @see ZonedDateTime#now(ZoneId) 
     * @param id           the id
     * @param name         the name
     * @param coordinates  the coordinates
     * @param creationDate the creation date
     * @param age          the age
     * @param weight       the weight
     * @param color        the color
     * @param type         the type
     * @param head         the head
     */
    public Dragon(Long id, String name, Coordinates coordinates, ZonedDateTime creationDate, Integer age, Long weight, Color color, Base.DragonType type, Base.DragonHead head, String creator) {

        this.id = id;
        this.creationDate = creationDate;
        this.name = name;
        this.creationDate = ZonedDateTime.now();
        this.coordinates = coordinates;
        this.setAge(age);
        this.setWeight(weight);
        this.color = color;
        this.type = type;
        this.setHead(head);
        this.creator = creator;
    }
    public String getCreator(){
        return creator;
}

    /**
     * Пустой конструктор
     */
    public Dragon() {

    }


    @Override
    public String toString() {
        return "Dragon{"
                + "id =" + getId()
                + ", name =" + getName()
                + ", coordinates =" + getCoordinates()
                + ", creationDate =" + getCreationDate()
                + ", age =" + getAge()
                + ", weight =" + getWeight()
                + ", color =" + getColor()
                + ", type =" + getType()
                + ", head =" + getHead()
                + ", creator = "+getCreator()
                + '}';
    }

    /**
     * Gets id.
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id the id
     */
    public void setId(Long id) {
        this.id = id;
    }
    public void setCreationDate(ZonedDateTime creationDate){
        this.creationDate = creationDate;
    }
    /**
     * Gets name.
     *
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets name.
     *
     * @param name the name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets coordinates.
     *
     * @return the coordinates
     */
    public Coordinates getCoordinates() {
        return coordinates;
    }

    /**
     * Sets coordinates.
     *
     * @param coordinates the coordinates
     */
    public void setCoordinates(Coordinates coordinates) {
        this.coordinates = coordinates;
    }

    /**
     * Gets creation date.
     *
     * @return the creation date
     */
    public ZonedDateTime getCreationDate() {
        return creationDate;
    }
    /**
     * Gets age.
     *
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * Sets age.
     *
     * @param age the age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * Gets weight.
     *
     * @return the weight
     */
    public Long getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(Long weight) {
        this.weight = weight;
    }

    /**
     * Gets color.
     *
     * @return the color
     */
    public Color getColor() {
        return color;
    }

    /**
     * Sets color.
     *
     * @param color the color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     * Gets type.
     *
     * @return the type
     */
    public DragonType getType() {
        return type;
    }

    /**
     * Sets type.
     *
     * @param type the type
     */
    public void setType(DragonType type) {
        this.type = type;
    }

    /**
     * Gets head.
     *
     * @return the head
     */
    public DragonHead getHead() {
        return head;
    }

    /**
     * Sets head.
     *
     * @param head the head
     */
    public void setHead(DragonHead head) {
        this.head = head;
    }



}


