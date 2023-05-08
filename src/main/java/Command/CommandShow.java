package Command;

import File.CollectionManager;

/**
 * Команда выводит в стандартный поток вывода все элементы коллекции в строковом представлении
 */
public class CommandShow implements Command {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор класса
     *
     * @param collectionManager the collection manager - хранит ссылку на объект
     */
    public CommandShow(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    /**Метод, запускающий работу команды
     * @see CollectionManager#show()  */
    @Override
    public void execute() {
        try {
            collectionManager.show();
        } catch (Exception e) {
            System.err.println("Exception"+e.getMessage());
        }


    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription() {
        return "Команда выводит в стандартный поток вывода все элементы коллекции в строковом представлении";
    }
}
