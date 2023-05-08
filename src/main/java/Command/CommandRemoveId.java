package Command;

import File.CollectionManager;

/**
 * удаляет элемент из коллекции по его id
 */
public class CommandRemoveId implements CommandWithArguments {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    private final CollectionManager collectionManager;
    /**
     * Поле, хранящее массив аргументов команды.
     */
    private String[] arg;

    /**
     * Конструктор класса
     *
     * @param collectionManager the collection manager - ссылка на объект

     */
    public CommandRemoveId(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    /**Метод, запускающий работу команды
     * @see CollectionManager#removeById(Long)  */
    @Override
    public void execute() {
        try {
            if(CheckUser.checkUsers()) {
                collectionManager.removeById(Long.parseLong(arg[0]));
            } else {
                System.out.println("Вы не авторизованы в программе");
            }
        } catch  (IndexOutOfBoundsException ex) {
            System.err.println("Не указаны аргументы команды.");
        } catch (NumberFormatException ex) {
            System.err.println("Формат аргумента не соответствует целочисленному");
        }
    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription() {
        return " удаляет элемент из коллекции по его id";
    }
    /**Метод, возвращающий аргумент для команды*/
    @Override
    public void getArguments(String[] arg) {
        this.arg = arg;

    }
}
