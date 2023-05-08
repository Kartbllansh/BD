package Command;

import File.CollectionManager;

/**
 * Команда выводит значения поля type всех элементов в порядке убывания
 */
public class CommandPrintType implements Command {
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    CollectionManager collectionManager;

    /**
     * Конструтор класса
     *
     * @param collectionManager the collection manager - ссылка на объект
     */
    public CommandPrintType(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    /**Метод, запускающий работу команды
     * @see CollectionManager#printDescendingType()  */
    @Override
    public void execute() {
        try {
            collectionManager.printDescendingType();
        } catch (Exception e) {
            System.err.println("EXception"+e.getMessage());
        }
    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription() {
        return "Команда выводит значения поля type всех элементов в порядке убывания";
    }
}
