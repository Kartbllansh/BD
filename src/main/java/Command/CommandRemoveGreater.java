package Command;

import File.CollectionManager;


/**
 * Команда удаляет из коллекции все элементы, превышающие заданный. Вы задаете команде ID дракона по которому хотите сравнивать, если хотите сравнивать по новому введите любое число(которое не является ID)
 */
public class CommandRemoveGreater implements CommandWithArguments {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    CollectionManager collectionManager;
    /**
     * Поле, хранящее массив аргументов команды.
     */
    String[] arg;

    /**
     * Конструтор класса
     *
     * @param collectionManager the collection manager - ссылка на объект
     * @exception   IndexOutOfBoundsException index
     * @exception NumberFormatException format
     */
    public CommandRemoveGreater(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    /**Метод, запускающий работу команды
     * @see CollectionManager#removeGreater(Long)  */
    @Override
    public void execute() {

        try {
            if(CheckUser.checkUsers()) {
                collectionManager.gread(Double.parseDouble(arg[0]));
            }else {
                System.out.println("Вы не авторизованы в программе");
            }
        } catch  ( IndexOutOfBoundsException ex) { //IndexOutOfBoundsException
            System.err.println("Не указаны аргументы команды.");
        } catch (NumberFormatException ex) {
            System.err.println("Формат аргумента не соответствует целочисленному");
        }

    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription() {
        return "Команда удаляет из коллекции все элементы, превышающие заданный. Работает по полю size";
    }
    /**Метод, возвращающий аргумент для команды*/
    @Override
    public void getArguments(String[] arg) {
     this.arg = arg;
    }
}
