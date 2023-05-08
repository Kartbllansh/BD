package Command;
import File.CollectionManager;


/**
 * Команда удаляет из коллекции один элемент, значение поля type которого эквивалентно заданному
 */
public class CommandRemoveType implements CommandWithArguments {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    CollectionManager collectionManager;
    /**
     * Поле, хранящее массив аргументов команды.
     */
    String[] arg;

    /**
     * Конструктор класса
     *
     * @param collectionManager the collection manager - хранящий ссылку на объект

     */
    public CommandRemoveType(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    /**Метод, запускающий работу команды
     * @see CollectionManager#removeByType(String)  */
    @Override
    public void execute() {
        try {
            if(CheckUser.checkUsers()) {
                collectionManager.removeByType(arg[0]);
            }else {
                System.out.println("Вы не авторизованы в программе");
            }
        } catch ( IndexOutOfBoundsException ex) { //
            System.err.println("Не указаны аргументы команды.");
        } catch (NumberFormatException ex) {
            System.err.println("Формат аргумента не соответствует целочисленному");
        } catch (IllegalArgumentException e){
            System.err.println("Не существует такого типа");
        }
    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription() {
        return "Команда удаляет из коллекции один элемент, значение поля type которого эквивалентно заданному";
    }
    /**Метод, возвращающий аргумент для команды*/
    @Override
    public void getArguments(String[] arg) {
        this.arg = arg;

    }
}
