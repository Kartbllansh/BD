package Command;

import File.CollectionManager;

/**
 * The type Command print age.
 */
public class CommandPrintAge implements Command {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    private final CollectionManager collectionManager;

    /**
     * Конструктор класса
     *
     * @param collectionManager the collection manager - ссылка на объект класса CollectionManager
     */
    public CommandPrintAge(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    /**Метод, запускающий работу команды
     * @see CollectionManager#printAscedingAge()  */
    @Override
    public void execute() {

            collectionManager.printAscedingAge();
    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription() {
        return "Команда выводит значения поля age всех элементов в порядке возрастания";
    }
}
