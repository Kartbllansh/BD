package Command;

import File.CollectionManager;

/**
 * Команда выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
 */
public class InfoCommand implements Command{
    /**
     * Поле, хранящее ссылку на объект класса CollectionManager..
     */
    CollectionManager collectionManager;

    /**
     * Конструтор класса
     *
     * @param collectionManager the collection manager - хранящий ссылку на объект
     */
    public InfoCommand(CollectionManager collectionManager){
        this.collectionManager = collectionManager;
    }
    /**Метод, запускающий работу команды
     * @see CollectionManager#getInfo()  */
    @Override
    public void execute() {
     collectionManager.getInfo();

    }
    /**Метод, возвращающий описание команды*/
    @Override
    public String getDescription(){
        return "Команда выводит в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)";
    }
}
